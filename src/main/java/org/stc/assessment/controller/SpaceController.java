package org.stc.assessment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stc.assessment.model.item.folder.FolderRequest;
import org.stc.assessment.model.item.folder.FolderResponse;
import org.stc.assessment.model.item.space.SpaceRequest;
import org.stc.assessment.model.item.space.SpaceResponse;
import org.stc.assessment.service.file.FileService;
import org.stc.assessment.service.folder.FolderService;
import org.stc.assessment.service.space.SpaceService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class SpaceController {

    private final SpaceService spaceService;
    private final FolderService folderService;

    public SpaceController(SpaceService spaceService,
                           FolderService folderService) {
        this.spaceService = spaceService;
        this.folderService = folderService;
    }


    @PostMapping("/spaces")
    public ResponseEntity<SpaceResponse> addSpace(@RequestBody SpaceRequest spaceRequest) {
        return ok(spaceService.addSpace(spaceRequest));
    }

    @PostMapping("/spaces/{space_Id}/folders")
    public ResponseEntity<FolderResponse> addFolder(@PathVariable(name = "space_Id") Long spaceId,
                                                    @RequestBody FolderRequest folderRequest) {
        return ok(folderService.addFolder(spaceId, folderRequest));
    }

}

