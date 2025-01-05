package org.stc.assessment.model.item.file;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class FileMetadataRequest {
    @JsonProperty("user_email")
    private String userEmail;
}
