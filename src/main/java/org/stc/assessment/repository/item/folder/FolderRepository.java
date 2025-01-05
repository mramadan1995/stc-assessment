package org.stc.assessment.repository.item.folder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.assessment.model.item.folder.Folder;
import org.stc.assessment.model.item.space.Space;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {

}
