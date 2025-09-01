package reg.repos.defs;

import eu.oberon.oss.demos.reg.entities.defs.AuditedBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseAuditedEntityRepository<I, V, U, D, T extends AuditedBaseEntity<I, V, U, D>> extends JpaRepository<T, I> {
}
