package org.stc.assessment.service.permission;

import org.springframework.stereotype.Service;
import org.stc.assessment.model.item.Item;
import org.stc.assessment.model.permission.PermissionLevel;

@Service
public class PermissionService {

    public boolean checkAccess(String userEmail, Item item) {
        return item.getPermissionGroup().getPermissions().stream()
                .noneMatch(permission -> permission.getUserEmail().equals(userEmail) &&
                        permission.getPermissionLevel() == PermissionLevel.EDIT);
    }

}
