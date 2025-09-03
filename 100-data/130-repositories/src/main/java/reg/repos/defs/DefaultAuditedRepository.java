package reg.repos.defs;

import eu.oberon.oss.demos.reg.entities.defs.AuditedBaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Default repository for Audited entities.
 * <p>
 * This implementation resolves the generic parameters from the interface as follows
 * <ul>
 * <li>{@link UUID} as the class type for {@literal <I>}</li>
 * <li>{@link Integer} as the class type for {@literal <V>} </li>
 * <li>{@link String} as the class type for {@literal <U>}</li>
 * <li>{@link LocalDateTime} as the class type for {@literal <D>}</li>
 * </ul>
 *
 * @param <T> Reference to an implementation of the {@link AuditedBaseEntity} interface
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@NoRepositoryBean
public interface DefaultAuditedRepository<T extends AuditedBaseEntity<UUID, Integer, String, LocalDateTime>> extends AuditedEntityRepository<UUID, Integer, String, LocalDateTime, T> {
}
