package eu.oberon.oss.demos.reg.entities.defs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseEntityRepository<I, T extends BaseEntity<I>> extends JpaRepository<T, I> {
}
