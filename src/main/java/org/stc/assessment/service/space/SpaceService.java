package org.stc.assessment.service.space;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.stc.assessment.model.item.Item;
import org.stc.assessment.model.item.space.Space;
import org.stc.assessment.model.item.space.SpaceRequest;
import org.stc.assessment.model.item.space.SpaceResponse;
import org.stc.assessment.repository.item.ItemRepository;
import org.stc.assessment.repository.item.space.SpaceRepository;
import org.stc.assessment.repository.permission.PermissionGroupRepository;

import static org.stc.assessment.model.item.file.ItemType.SPACE;

@Service
public class SpaceService {

    private final SpaceRepository spaceRepository;
    private final PermissionGroupRepository permissionGroupRepository;
    private final ModelMapper mapper;

    private static final String ADMIN_GROUP_CODE = "Admin_Group";

    public SpaceService(SpaceRepository spaceRepository,
                        PermissionGroupRepository permissionGroupRepository, ModelMapper mapper) {
        this.spaceRepository = spaceRepository;
        this.permissionGroupRepository = permissionGroupRepository;
        this.mapper = mapper;
    }

    @Transactional
    public SpaceResponse addSpace(SpaceRequest spaceRequest) {
        Space space = new Space();
        space.setName(spaceRequest.getName());
        space.setPermissionGroup(permissionGroupRepository.findByCode(ADMIN_GROUP_CODE).
                orElseThrow(() -> new EntityNotFoundException("PermissionGroup [ " + ADMIN_GROUP_CODE + " ] not found!")));
        spaceRepository.save(space);
        return mapper.map(space, SpaceResponse.class);
    }
}
