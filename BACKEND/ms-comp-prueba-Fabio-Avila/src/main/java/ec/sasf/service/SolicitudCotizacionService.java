package ec.sasf.service;

import ec.sasf.model.SolicitudCotizacion;
import ec.sasf.repository.SolicitudCotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudCotizacionService {

    private final SolicitudCotizacionRepository solicitudCotizacionRepository;

    @Autowired
    public SolicitudCotizacionService(SolicitudCotizacionRepository solicitudCotizacionRepository) {
        this.solicitudCotizacionRepository = solicitudCotizacionRepository;
    }

    public List<SolicitudCotizacion> getAllSolicitudesCotizacion() {
        return solicitudCotizacionRepository.findAll();
    }

    public SolicitudCotizacion getSolicitudCotizacionById(Long id) {
        return solicitudCotizacionRepository.findById(id).orElse(null);
    }

    public SolicitudCotizacion saveSolicitudCotizacion(SolicitudCotizacion solicitudCotizacion) {
        return solicitudCotizacionRepository.save(solicitudCotizacion);
    }

    public void deleteSolicitudCotizacion(Long id) {
        solicitudCotizacionRepository.deleteById(id);
    }
}
