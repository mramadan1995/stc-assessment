package org.stc.assessment.repository.permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stc.assessment.model.permission.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
