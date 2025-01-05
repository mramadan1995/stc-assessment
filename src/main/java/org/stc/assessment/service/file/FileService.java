package org.stc.assessment.service.file;

import jakarta.persistence.EntityNotFoundException;
import jakarta.security.auth.message.AuthException;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.stc.assessment.model.item.file.File;
import org.stc.assessment.model.item.file.FileBinary;
import org.stc.assessment.model.item.file.FileMetadata;
import org.stc.assessment.model.item.file.FileMetadataRequest;
import org.stc.assessment.model.item.file.FileResponse;
import org.stc.assessment.model.item.folder.Folder;
import org.stc.assessment.repository.file.FileBinaryRepository;
import org.stc.assessment.repository.file.FileRepository;
import org.stc.assessment.repository.item.folder.FolderRepository;
import org.stc.assessment.service.permission.PermissionService;

@Service
public class FileService {

    private final FolderRepository folderRepository;
    private final FileRepository fileRepository;
    private final PermissionService permissionService;
    private final FileBinaryRepository fileBinaryRepository;
    private final ModelMapper mapper;

    public FileService(FolderRepository folderRepository,
                       FileRepository fileRepository,
                       PermissionService permissionService, FileBinaryRepository fileBinaryRepository, ModelMapper mapper) {
        this.folderRepository = folderRepository;
        this.fileRepository = fileRepository;
        this.permissionService = permissionService;
        this.fileBinaryRepository = fileBinaryRepository;
        this.mapper = mapper;
    }

    @SneakyThrows
    @Transactional
    @SuppressWarnings("unchecked")
    public FileResponse addFile(Long folderId, FileMetadataRequest fileMetadataRequest ,
                                MultipartFile multipartFile) {
        Folder folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new EntityNotFoundException("folder not found"));

        if (permissionService.checkAccess(fileMetadataRequest.getUserEmail(), folder)) {
            throw new AuthException("User does not have EDIT access to create a file.");
        }

        File file = new File();
        file.setName(multipartFile.getName());
        file.setParent(folder);
        file.setPermissionGroup(folder.getPermissionGroup());
        fileRepository.save(file);


        FileBinary fileBinary = new FileBinary();
        fileBinary.setBinaryData(multipartFile.getBytes());
        fileBinary.setFile(file);
        fileBinaryRepository.save(fileBinary);
        return mapper.map(file,FileResponse.class);

    }

    public FileBinary getFileBinaryById(Long fileId) {
        return fileBinaryRepository.findByFileId(fileId).orElseThrow(() ->
                new EntityNotFoundException("File with id [ " + fileId + " ] not found!"));
    }

    public FileMetadata getFileMetadata(Long fileId, String userEmail) {
       return fileRepository.findByIdAndEmail(fileId, userEmail).orElseThrow(() ->
                new EntityNotFoundException("File with id [ " + fileId + " ] not found!"));
    }


}
