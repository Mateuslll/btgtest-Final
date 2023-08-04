package br.com.btg.test.btgtest.controller;
import br.com.btg.test.btgtest.model.Client;
import br.com.btg.test.btgtest.model.RequestClient;
import br.com.btg.test.btgtest.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")

public class ClientController {
    @Autowired
    private ClientRepository repository;

    @GetMapping("/clients")
    public ResponseEntity getAllClients(){
        var allClients = repository.findAll();
        return ResponseEntity.ok(allClients);
    }
    @PostMapping("/register")
    public ResponseEntity registerClient (@RequestBody @Valid RequestClient data){
        Client newClient = new Client(data);
        repository.save(newClient);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable int clientId, @RequestBody @Valid RequestClient data) {
        Optional<Client> optionalClient = repository.findById(clientId);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setName(data.name());
            client.setCpf(data.CPF());
            Client updatedClient = repository.save(client);
            return ResponseEntity.ok(updatedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
