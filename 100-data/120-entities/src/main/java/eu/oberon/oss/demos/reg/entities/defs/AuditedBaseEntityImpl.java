package eu.oberon.oss.demos.reg.entities.defs;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Default implementation for the {@link AuditedBaseEntity} interface. This implementation resolves the generic
 * parameters from the interface as follows
 * <ul>
 * <li>{@link UUID} as the class type for {@literal <I>}</li>
 * <li>{@link Integer} as the class type for {@literal <V>} </li>
 * <li>{@link String} as the class type for {@literal <U>}</li>
 * <li>{@link LocalDateTime} as the class type for {@literal <D>}</li>
 * </ul>
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@Getter
@Setter
@MappedSuperclass
public class AuditedBaseEntityImpl implements AuditedBaseEntity<UUID, Integer, String, LocalDateTime> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private Integer version;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;

}