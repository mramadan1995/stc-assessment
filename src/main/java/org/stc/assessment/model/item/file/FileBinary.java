package org.stc.assessment.model.item.file;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;
import org.stc.assessment.model.AbstractBaseEntity;

@Getter
@Setter
@Entity
@Table(name = "file_binary")
public class FileBinary extends AbstractBaseEntity {

    @Lob
    @JdbcType(value = VarbinaryJdbcType.class)
    @Column(name = "binary_data")
    private byte[] binaryData;

    @OneToOne
    @JoinColumn(name = "item_id", unique = true)
    private File file;
}
