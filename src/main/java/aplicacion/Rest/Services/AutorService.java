package aplicacion.Rest.Services;

import aplicacion.Rest.Entities.Autor;
import aplicacion.Rest.Repositories.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements BaseService<Autor> {

    //@Autowired
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (autorRepository.existsById(id)) {
                autorRepository.deleteById(id);
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
    public List<Autor> findAll() throws Exception {
        try {
            return autorRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor findById(Long id) throws Exception {
        try {
            Optional<Autor> entityOptional = autorRepository.findById(id);
            if (entityOptional.isPresent()) {
                return entityOptional.get();
            } else {
                throw new Exception("Autor no encontrado con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor save(Autor entity) throws Exception {
        try {
            entity = autorRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor update(Long id, Autor entity) throws Exception {
        try {

            Autor autor = autorRepository.findById(id)
                    .orElseThrow(() -> new Exception("Autor no encontrado con id: " + id));

            autor.setNombre(entity.getNombre());
            autor.setApellido(entity.getApellido());
            autor.setBiografia(entity.getBiografia());

            return autorRepository.save(autor);
        } catch (Exception e) {
            throw new Exception("Error al actualizar el autor: " + e.getMessage());
        }
    }
}