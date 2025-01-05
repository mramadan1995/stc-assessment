package org.stc.assessment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stc.assessment.model.item.file.FileBinary;
import org.stc.assessment.service.file.FileService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/files")
public class FileController {


    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{file_id}/binary")
    public ResponseEntity<byte[]> downloadFile(@PathVariable(name = "file_id") Long id) {
        FileBinary fileBinary = fileService.getFileBinaryById(id);
        return ok()
                .body(fileBinary.getBinaryData());
    }

    @GetMapping("/files/{file_id}/metadata")
    public ResponseEntity<Object> getFileMetadata(
            @PathVariable(name = "file_id") Long itemId,
            @RequestParam(name = "user_email") String userEmail) {
        return ok(fileService.getFileMetadata(itemId, userEmail));
    }
}
