package ec.sasf.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "solicitud_cotizacion")
@Entity
@EntityListeners({AuditingEntityListener.class})
// extends Auditable implements Serializable
public class SolicitudCotizacion extends Auditable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    private User cliente;

    @ManyToOne
    private Evento evento; 

    private LocalDateTime fechaCreacion;

    private String motivoRechazo;
    private BigDecimal precioCalculado;
}
