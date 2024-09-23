package aplicacion.Rest.Controllers;


import aplicacion.Rest.Entities.Localidad;
import aplicacion.Rest.Services.LocalidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class LocalidadController {

    private LocalidadService localidadService;

    public LocalidadController(LocalidadService libroService){
        this.localidadService = libroService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Localidad entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Localidad entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(localidadService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(localidadService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
}
