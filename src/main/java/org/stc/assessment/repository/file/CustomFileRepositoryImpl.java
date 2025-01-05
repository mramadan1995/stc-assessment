package org.stc.assessment.repository.file;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.stc.assessment.model.item.file.FileMetadata;

@Repository
public class CustomFileRepositoryImpl implements CustomFileRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<FileMetadata> findByIdAndEmail(Long fileId, String userEmail) {
        String sql =  "SELECT i.id , i.name , p.user_email ,p.permission_level , pg.name " +
                " FROM items i" +
                " JOIN permission_group pg ON i.permission_group_id = pg.id" +
                " JOIN Permissions p ON pg.id = p.group_id" +
                " WHERE i.type = 'File' AND i.id = :fileId AND p.user_email = :userEmail";
        List<Object[]> results = entityManager.createNativeQuery(sql)
                .setParameter("fileId", fileId)
                .setParameter("userEmail", userEmail)
                .getResultList();
        if (results.isEmpty()) {
            return Optional.empty();
        }
        Object[] row = results.get(0);
        return Optional.of(new FileMetadata(
                ((Long) row[0]),
                (String) row[1],
                (String) row[2],
                (String) row[3],
                (String) row[4]
        ));
    }
}
