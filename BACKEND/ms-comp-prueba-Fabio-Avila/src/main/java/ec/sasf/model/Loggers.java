package ec.sasf.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import ec.sasf.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios_roles")
@EntityListeners({AuditingEntityListener.class})
public class Loggers extends Auditable implements Serializable {

    @Id
    @Column(name = "usuarios", length = 20, unique = true)
    private String usuario;

    @Email
    @Column(name = "email_usuarios", length = 30, unique = true)
    private String email_usuarios;

    @Column(name = "clave")
    private String clave;

    @Column(name = "nombre_de_usuario")
    private String nombre_de_usuario;

    @Column(name = "apellido_de_usuario")
    private String apellido_de_usuario;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<LoggersRoles> roles;


    
    @Override
    public String toString() {
        return "Loggers [usuario=" + usuario + ", email_usuarios=" + email_usuarios + ", clave="
                + clave + ", roles=" + roles + "]";
    }

    
    
}
