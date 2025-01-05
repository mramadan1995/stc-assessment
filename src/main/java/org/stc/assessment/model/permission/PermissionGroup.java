package org.stc.assessment.model.permission;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

import org.stc.assessment.model.AbstractBaseEntity;

@Getter
@Setter
@Entity
@Table(name = "permission_group")
public class PermissionGroup extends AbstractBaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Permission> permissions;

}
