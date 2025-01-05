package org.stc.assessment.model.permission;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import org.stc.assessment.model.AbstractBaseEntity;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@Entity
@Table(name = "permissions")
public class Permission extends AbstractBaseEntity {

    @Column(name = "user_email")
    private String userEmail;

    @Enumerated(STRING)
    @Column(name = "permission_level")
    private PermissionLevel permissionLevel;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private PermissionGroup group;

}
