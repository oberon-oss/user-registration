package reg.repos.defs;

import eu.oberon.oss.demos.reg.entities.defs.BaseEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

/**
 * Default repository for Base entities, using UUID as @{@link Id}/Primary key.
 *
 * @param <T> Reference to an implementation of the {@link BaseEntity} interface
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@NoRepositoryBean
public interface DefaultRepository<T extends BaseEntity<UUID>> extends JpaRepository<T, UUID> {
}
