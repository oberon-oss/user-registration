package reg.repos.defs;

import eu.oberon.oss.demos.reg.entities.defs.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository template for use with entities derived from {@link BaseEntity} entities.
 *
 * @param <I> The class type used as ID field (primary key)
 * @param <T> The target entity to be used by this repository
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@NoRepositoryBean
public interface BaseEntityRepository<I, T extends BaseEntity<I>> extends JpaRepository<T, I> {
}
