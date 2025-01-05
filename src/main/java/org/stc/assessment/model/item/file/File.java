package org.stc.assessment.model.item.file;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import org.stc.assessment.model.item.Item;

@Entity
@DiscriminatorValue("File")
public class File extends Item {

}
