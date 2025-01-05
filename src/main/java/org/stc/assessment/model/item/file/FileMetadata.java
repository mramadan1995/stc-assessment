package org.stc.assessment.model.item.file;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileMetadata {

    private Long id;
    private String fileName;
    private String userEmail;
    private String permissionLevel;
    private String groupName;

    public FileMetadata(Long id, String fileName,
                        String userEmail, String permissionLevel, String groupName) {
        this.id = id;
        this.fileName = fileName;
        this.userEmail = userEmail;
        this.permissionLevel = permissionLevel;
        this.groupName = groupName;
    }
}
