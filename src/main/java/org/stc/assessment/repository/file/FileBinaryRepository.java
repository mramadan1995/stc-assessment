package org.stc.assessment.repository.file;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.assessment.model.item.file.FileBinary;

@Repository
public interface FileBinaryRepository extends JpaRepository<FileBinary, Long> {

    Optional<FileBinary> findByFileId(Long fileId);
}
