package ec.sasf.controller;

import ec.sasf.model.Evento;
import ec.sasf.model.SolicitudCotizacion;
import ec.sasf.service.EventoService;
import ec.sasf.service.SolicitudCotizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;
    private final SolicitudCotizacionService solicitudCotizacionService;

    @Autowired
    public EventoController(EventoService eventoService, SolicitudCotizacionService solicitudCotizacionService) {
        this.eventoService = eventoService;
        this.solicitudCotizacionService = solicitudCotizacionService;
    }

    // Métodos para Eventos

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.getAllEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventoById(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        if (evento != null) {
            return new ResponseEntity<>(evento, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento not found");
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ORGANIZADOR')")
    public ResponseEntity<?> saveEvento(@RequestBody Evento evento) {
        Evento savedEvento = eventoService.saveEvento(evento);
        return new ResponseEntity<>(savedEvento, HttpStatus.CREATED);
    }

    @GetMapping("/solicitudes-cotizacion")
    public List<SolicitudCotizacion> getAllSolicitudesCotizacion() {
        return solicitudCotizacionService.getAllSolicitudesCotizacion();
    }

    @GetMapping("/solicitudes-cotizacion/{id}")
    public ResponseEntity<?> getSolicitudCotizacionById(@PathVariable Long id) {
        SolicitudCotizacion solicitudCotizacion = solicitudCotizacionService.getSolicitudCotizacionById(id);
        if (solicitudCotizacion != null) {
            return new ResponseEntity<>(solicitudCotizacion, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Solicitud de Cotización not found");
        }
    }

    @PostMapping("/solicitudes-cotizacion")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ORGANIZADOR')")
    public ResponseEntity<?> saveSolicitudCotizacion(@RequestBody SolicitudCotizacion solicitudCotizacion) {
        SolicitudCotizacion savedSolicitudCotizacion = solicitudCotizacionService.saveSolicitudCotizacion(solicitudCotizacion);
        return new ResponseEntity<>(savedSolicitudCotizacion, HttpStatus.CREATED);
    }

}
