package org.stc.assessment.service.folder;

import jakarta.persistence.EntityNotFoundException;
import jakarta.security.auth.message.AuthException;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.stc.assessment.model.item.folder.Folder;
import org.stc.assessment.model.item.folder.FolderRequest;
import org.stc.assessment.model.item.folder.FolderResponse;
import org.stc.assessment.model.item.space.Space;
import org.stc.assessment.repository.item.folder.FolderRepository;
import org.stc.assessment.repository.item.space.SpaceRepository;
import org.stc.assessment.service.permission.PermissionService;

@Service
public class FolderService {

    private final SpaceRepository spaceRepository;
    private final PermissionService permissionService;
    private final FolderRepository folderRepository;
    private final ModelMapper mapper;

    public FolderService(SpaceRepository spaceRepository, PermissionService permissionService, FolderRepository folderRepository, ModelMapper mapper) {
        this.spaceRepository = spaceRepository;
        this.permissionService = permissionService;
        this.folderRepository = folderRepository;
        this.mapper = mapper;
    }

    @SneakyThrows
    @Transactional
    public FolderResponse addFolder(Long spaceId ,FolderRequest folderRequest) {
        Space space = spaceRepository.findById(spaceId)
                .orElseThrow(() -> new EntityNotFoundException("Parent Space not found"));
        if (permissionService.checkAccess(folderRequest.getUserEmail(), space)) {
            throw new AuthException("User does not have EDIT access to create a folder.");
        }
        Folder folder = new Folder();
        folder.setName(folderRequest.getName());
        folder.setParent(space);
        folder.setPermissionGroup(space.getPermissionGroup());
        folderRepository.save(folder);
        return mapper.map(folder,FolderResponse.class);
    }
}

