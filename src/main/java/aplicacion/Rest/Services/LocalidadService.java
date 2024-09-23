package aplicacion.Rest.Services;

import aplicacion.Rest.Entities.Localidad;

import aplicacion.Rest.Repositories.LocalidadRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadService implements BaseService<Localidad> {

    //@Autowired Es lo mismo que declarar el constructor de abajo
    private final LocalidadRepository localidadRepository;

    public LocalidadService(LocalidadRepository localidadRepository) {
        this.localidadRepository = localidadRepository;
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (localidadRepository.existsById(id)) {
                localidadRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public List<Localidad> findAll() throws Exception {
        try {
            return localidadRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad findById(Long id) throws Exception {
        try {
            Optional<Localidad> entityOptional = localidadRepository.findById(id);
            if (entityOptional.isPresent()) {
                return entityOptional.get();
            } else {
                throw new Exception("Localidad no encontrada con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad save(Localidad entity) throws Exception {
        try {
            entity = localidadRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad update(Long id, Localidad entity) throws Exception {
        try {

            Localidad localidad = localidadRepository.findById(id)
                    .orElseThrow(() -> new Exception("Localidad no encontrada con id: " + id));

            localidad.setDenominacion(entity.getDenominacion());

            return localidadRepository.save(localidad);
        } catch (Exception e) {
            throw new Exception("Error al actualizar la localidad: " + e.getMessage());
        }
    }
}