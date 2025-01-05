package org.stc.assessment.repository.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.assessment.model.item.file.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> , CustomFileRepository {


}
