package aplicacion.Rest.Services;

import aplicacion.Rest.Entities.Domicilio;

import aplicacion.Rest.Repositories.DomicilioRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements BaseService<Domicilio> {

    //@Autowired
    private final DomicilioRepository domicilioRepository;

    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (domicilioRepository.existsById(id)) {
                domicilioRepository.deleteById(id);
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
    public List<Domicilio> findAll() throws Exception {
        try {
            return domicilioRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio findById(Long id) throws Exception {
        try {
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            if (entityOptional.isPresent()) {
                return entityOptional.get();
            } else {
                throw new Exception("Domicilio no encontrado con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio save(Domicilio entity) throws Exception {
        try {
            entity = domicilioRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Domicilio update(Long id, Domicilio entity) throws Exception {
        try {
            Domicilio domicilio = domicilioRepository.findById(id)
                    .orElseThrow(() -> new Exception("Domicilio no encontrado con id: " + id));


            domicilio.setNumero(entity.getNumero());
            domicilio.setCalle(entity.getCalle());



            return domicilioRepository.save(domicilio);
        } catch (Exception e) {
            throw new Exception("Error al actualizar el domicilio: " + e.getMessage());
        }
    }
}