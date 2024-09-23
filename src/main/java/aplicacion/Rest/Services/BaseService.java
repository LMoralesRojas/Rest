package aplicacion.Rest.Services;

import java.util.List;

public interface BaseService <E> {
    /* Trae listas */
    public List<E> findAll() throws Exception;
    /* trea entidades segun su id*/
    public E findById(Long id) throws Exception;
    /* crea una nueva entidad*/
    public E save(E entity) throws Exception;
    /*tiene lo parametros de manera actualizada*/
    public E update(Long id, E entity) throws Exception;
    /*elimina un registro de la base de datos*/
    public boolean delete(Long id) throws Exception;
}
