package one.digitalInnovation.java_design_patterns.controller;

import one.digitalInnovation.java_design_patterns.model.Client;
import one.digitalInnovation.java_design_patterns.service.ClientService;
import one.digitalInnovation.java_design_patterns.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientRestController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> searchAll(){
        return ResponseEntity.ok(clientService.searchAll());
    }

   /* @GetMapping("/{id}")
    public ResponseEntity<Client> searchAllById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.searchAllById(id));
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchById(@PathVariable Long id) {
        try {
            Client client = clientService.searchAllById(id);
            return ResponseEntity.ok(client);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if not found
        }
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client){
        clientService.insert(client);
        return ResponseEntity.ok(client);
    }

   @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
