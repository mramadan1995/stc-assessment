package org.stc.assessment.model.item.space;

import lombok.Getter;
import lombok.Setter;

import org.stc.assessment.model.item.file.ItemType;

@Getter
@Setter
public class SpaceResponse {
    private Long id;
    private String name;
    private ItemType type;
}
