package reg.repos.defs;

import eu.oberon.oss.demos.reg.entities.defs.AuditedBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository template for use by {@link AuditedBaseEntity} implementations.
 *
 * @param <I> The class type used as ID field (primary key)
 * @param <V> The class type for storing revision numbers
 * @param <U> The class type containing the user information
 * @param <D> The class type capturing date/time of events
 * @param <T> The target entity to be used by this repository
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@NoRepositoryBean
public interface AuditedEntityRepository<I, V, U, D, T extends AuditedBaseEntity<I, V, U, D>> extends JpaRepository<T, I> {
}
