package org.stc.assessment.model.item.folder;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class FolderRequest {

    private String name;
    @JsonProperty("user_email")
    private String userEmail;
}
