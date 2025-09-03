package eu.oberon.oss.demos.reg.entities.defs;

import jakarta.persistence.Version;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Entries that can be used for audited entities.
 *
 * @param <I> The class type used as ID field (primary key)
 * @param <V> The class type for storing revision numbers
 * @param <U> The class type containing the user information
 * @param <D> The class type capturing date/time of events
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public interface AuditedBaseEntity<I, V, U, D> extends BaseEntity<I> {

    /**
     * Retrieves the revision number for the entity.
     *
     * @return The revision number
     *
     * @since 1.0.0
     */
    @Version
    V getVersion();

    /**
     * Sets the revision number for the entity.
     *
     * @param version The revision number
     *
     * @since 1.0.0
     */
    void setVersion(V version);

    /**
     * Retrieves the creation date for the entity instance.
     *
     * @return The creation date.
     *
     * @since 1.0.0
     */
    @CreatedDate
    D getCreatedDate();

    /**
     * Sets the creation date for the entity instance.
     *
     * @param createdDate The creation date.
     *
     * @since 1.0.0
     */
    void setCreatedDate(D createdDate);

    /**
     * Retrieves the user that created the entity instance.
     *
     * @return The user for the creation event.
     *
     * @since 1.0.0
     */
    @CreatedBy
    U getCreatedBy();

    /**
     * Sets the user that created the entity instance.
     *
     * @param createdBy The user for the creation event.
     *
     * @since 1.0.0
     */
    void setCreatedBy(U createdBy);

    /**
     * Retrieves the date of the last modification for the entity instance.
     *
     * @return The date/time of the last modification.
     *
     * @since 1.0.0
     */
    @LastModifiedDate
    D getLastModifiedDate();

    /**
     * Sets the date of the last modification for the entity instance.
     *
     * @param lastModifiedDate The date/time of the last modification.
     *
     * @since 1.0.0
     */
    void setLastModifiedDate(D lastModifiedDate);

    /**
     * Retrieves the user that modified the entity instance.
     *
     * @return The user for the modification event.
     *
     * @since 1.0.0
     */
    @LastModifiedBy
    U getLastModifiedBy();

    /**
     * Sets the user that modified the entity instance.
     *
     * @param lastModifiedBy The user for the modification event.
     *
     * @since 1.0.0
     */
    void setLastModifiedBy(U lastModifiedBy);
}