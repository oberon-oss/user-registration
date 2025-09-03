package reg.repos;

import eu.oberon.oss.demos.reg.entities.User;
import org.springframework.stereotype.Repository;
import reg.repos.defs.DefaultAuditedRepository;

@Repository
public interface UserRepository extends DefaultAuditedRepository<User> {
}
