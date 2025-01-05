package org.stc.assessment.repository.item.space;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.assessment.model.item.Item;
import org.stc.assessment.model.item.space.Space;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {

}
