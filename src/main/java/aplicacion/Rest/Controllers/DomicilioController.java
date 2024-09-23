package aplicacion.Rest.Controllers;

import aplicacion.Rest.Entities.Domicilio;
import aplicacion.Rest.Services.DomicilioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class DomicilioController {

    private DomicilioService domicilioService;

    public DomicilioController(DomicilioService domicilioService){
        this.domicilioService = domicilioService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Domicilio entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Domicilio entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(domicilioService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(domicilioService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
}
