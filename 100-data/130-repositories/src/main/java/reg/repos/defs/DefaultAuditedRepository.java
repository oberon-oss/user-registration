package reg.repos.defs;

import eu.oberon.oss.demos.reg.entities.defs.AuditedBaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.UUID;

@NoRepositoryBean
public interface DefaultAuditedRepository<T extends AuditedBaseEntity<UUID, Integer, String, LocalDateTime>> extends BaseAuditedEntityRepository<UUID, Integer, String, LocalDateTime, T> {
}
