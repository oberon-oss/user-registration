package reg.repos.defs;

import eu.oberon.oss.demos.reg.entities.defs.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface DefaultRepository<T extends BaseEntity<UUID>> extends JpaRepository<T, UUID> {
}
