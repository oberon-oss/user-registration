package eu.oberon.oss.demos.reg.entities.defs;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Default implementation for the {@link BaseEntity} interface. This implementation resolves the generic parameters from
 * the interface as follows
 * <ul>
 * <li>{@link UUID} as the class type for {@literal <I>}</li>
 * </ul>
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntityImpl implements BaseEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
}
