package aplicacion.Rest.Services;


import aplicacion.Rest.Entities.Libro;
import aplicacion.Rest.Repositories.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements BaseService<Libro> {

    //@Autowired
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {

        this.libroRepository = libroRepository;
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (libroRepository.existsById(id)) {
                libroRepository.deleteById(id);
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
    public List<Libro> findAll() throws Exception {
        try {
            return libroRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro findById(Long id) throws Exception {
        try {
            Optional<Libro> entityOptional = libroRepository.findById(id);
            if (entityOptional.isPresent()) {
                return entityOptional.get();
            } else {
                throw new Exception("Libro no encontrado con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro save(Libro entity) throws Exception {
        try {
            entity = libroRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro update(Long id, Libro entity) throws Exception {
        try {
            Libro libro = libroRepository.findById(id)
                    .orElseThrow(() -> new Exception("Libro no encontrado con id: " + id));
            libro.setTitulo(entity.getTitulo());
            libro.setFecha(entity.getFecha());
            libro.setPaginas(entity.getPaginas());
            libro.setGenero(entity.getGenero());
            libro.setAutor(entity.getAutor());
            return libroRepository.save(libro);
        } catch (Exception e) {
            throw new Exception("Error al actualizar el libro: " + e.getMessage());
        }
    }
}