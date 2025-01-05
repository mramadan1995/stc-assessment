package org.stc.assessment.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.stc.assessment.model.item.file.FileMetadataRequest;
import org.stc.assessment.model.item.file.FileResponse;
import org.stc.assessment.service.file.FileService;
import org.stc.assessment.service.folder.FolderService;
import org.stc.assessment.service.space.SpaceService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/folders")
public class FolderController {


    private final FileService fileService;

    public FolderController( FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/{folder_id}/files",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileResponse> addFile(@PathVariable(name = "folder_id") Long folderId ,
                                                @RequestPart("file") MultipartFile file,
                                                @RequestPart("metadata") String metadata) throws JsonProcessingException {
        FileMetadataRequest fileMetadataRequest = new ObjectMapper().
                readValue(metadata, FileMetadataRequest.class);
        return ok(fileService.addFile(folderId, fileMetadataRequest, file));
    }

}
