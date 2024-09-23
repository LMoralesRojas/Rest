package aplicacion.Rest.Services;

import aplicacion.Rest.Entities.Persona;
import aplicacion.Rest.Repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements BaseService<Persona> {

    //@Autowired Es lo mismo que declarar el constructor de abajo
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (personaRepository.existsById(id)) {
                personaRepository.deleteById(id);
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
    public List<Persona> findAll() throws Exception {
        try {
            return personaRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepository.findById(id);
            if (entityOptional.isPresent()) {
                return entityOptional.get();
            } else {
                throw new Exception("Persona no encontrada con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
            entity = personaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
            // Verifica si la entidad existe o lanza una excepción
            Persona persona = personaRepository.findById(id)
                    .orElseThrow(() -> new Exception("Persona no encontrada con id: " + id));

            // Actualiza los campos de la entidad recuperada con los valores de la nueva entidad
            persona.setNombre(entity.getNombre());
            persona.setApellido(entity.getApellido());
            // Agrega más setters para actualizar los campos necesarios

            // Guarda la entidad actualizada
            return personaRepository.save(persona);
        } catch (Exception e) {
            throw new Exception("Error al actualizar la persona: " + e.getMessage());
        }
    }
}