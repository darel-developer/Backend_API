package darelo.api.demo.controller;

import darelo.api.demo.entities.Client;
import darelo.api.demo.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> creer(@RequestBody Client client) {
        String message = this.clientService.creer(client);

        if (message.equals("L'adresse email existe déjà.")) {
            return ResponseEntity
                    .badRequest()
                    .body("{\"message\": \"" + message + "\"}");
        }

        return ResponseEntity
                .status(201)
                .body("{\"message\": \"" + message + "\"}");
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> rechercher() {
        return this.clientService.rechercher();
    }
    @GetMapping(path = "{id}",produces = APPLICATION_JSON_VALUE)
    public Client lire(@PathVariable int id) {
        return this.clientService.lire(id);
    }
}
