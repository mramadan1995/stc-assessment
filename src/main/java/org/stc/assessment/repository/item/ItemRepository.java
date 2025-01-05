package org.stc.assessment.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.assessment.model.item.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
