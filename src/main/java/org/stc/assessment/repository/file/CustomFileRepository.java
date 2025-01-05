package org.stc.assessment.repository.file;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.stc.assessment.model.item.file.FileMetadata;

@Repository
public interface CustomFileRepository {

     Optional<FileMetadata> findByIdAndEmail(Long fileId, String userEmail);
}
