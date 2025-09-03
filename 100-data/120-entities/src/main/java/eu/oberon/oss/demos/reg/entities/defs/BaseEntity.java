package eu.oberon.oss.demos.reg.entities.defs;

/**
 * Basic entity that acts as the root of all entities in a project
 *
 * @param <I> The class type used as ID field (primary key)
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public interface BaseEntity<I> {
    /**
     * Retrieves the ID for an entity (aka the Primary Key)
     *
     * @return The ID for the entity
     *
     * @since 1.0.0
     */
    I getId();

    /**
     * Sets the ID for the entity.
     *
     * @param id The ID to set.
     *
     * @since 1.0.0
     */
    void setId(I id);
}