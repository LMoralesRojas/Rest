package aplicacion.Rest.Controllers;

import aplicacion.Rest.Entities.Autor;

import aplicacion.Rest.Services.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class AutorController {
    private AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Autor entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Autor entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(autorService.update(id, entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(autorService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentelo mas tarde.\"}");
        }
    }
}
