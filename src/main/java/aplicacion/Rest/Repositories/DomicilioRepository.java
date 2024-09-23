package aplicacion.Rest.Repositories;

import aplicacion.Rest.Entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Dao es un patron  que separa por completo la logica de negocio de la logica de base de datos*/
@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {

}
