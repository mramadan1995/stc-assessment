package org.stc.assessment.model.item.space;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import org.stc.assessment.model.item.Item;

@Entity
@DiscriminatorValue("Space")
public class Space extends Item {
}
