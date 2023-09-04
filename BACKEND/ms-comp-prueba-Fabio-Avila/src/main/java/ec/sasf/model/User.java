package ec.sasf.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "users")
@EntityListeners({AuditingEntityListener.class})
public class User extends Auditable implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuarios", length = 20, unique = true)
    private String usuario;

    @Column(name = "nombre_de_usuario")
    private String nombre_de_usuario;

    @Column(name = "apellido_de_usuario")
    private String apellido_de_usuario;

    @Email
    @Column(name = "email_usuarios", length = 30, unique = true)
    private String email_usuarios;

    @Column(name = "clave")
    private String clave;

    
}