package org.stc.assessment.model.item.folder;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import org.stc.assessment.model.item.Item;

@Entity
@DiscriminatorValue("Folder")
public class Folder extends Item {

}
