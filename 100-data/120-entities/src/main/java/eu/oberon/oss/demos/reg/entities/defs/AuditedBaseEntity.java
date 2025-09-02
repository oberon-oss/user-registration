package eu.oberon.oss.demos.reg.entities.defs;

import jakarta.persistence.Version;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

public interface AuditedBaseEntity<I, V, U, D> extends BaseEntity<I> {

    @Version
    V getVersion();

    @CreatedDate
    D getCreatedDate();

    @CreatedBy
    U getCreatedBy();

    @LastModifiedDate
    D getLastModifiedDate();

    @LastModifiedBy
    U getLastModifiedBy();
}