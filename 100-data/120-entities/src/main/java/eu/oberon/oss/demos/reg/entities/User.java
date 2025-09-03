package eu.oberon.oss.demos.reg.entities;

import eu.oberon.oss.demos.reg.entities.defs.AuditedBaseEntityImpl;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Audited
@Table(name = "user")
public class User extends AuditedBaseEntityImpl {

    @Column(length = 50, nullable = false)
    @NotBlank
    private String firstName;

    @Column(length = 70, nullable = false)
    private String lastName;

    @Email
    @Column(nullable = false)
    private String email;
}