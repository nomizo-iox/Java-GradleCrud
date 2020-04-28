package com.nomizo.controller;


import com.nomizo.model.Client;
import com.nomizo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getClients() { return clientService.findClientss(); }

    @GetMapping("/client/id/{id}")
    public Client getClientById(@PathVariable int id) { return clientService.findClientById(id); }

    @GetMapping("/client/email/{email}")
    public Client getClientByEmail(@PathVariable String email) { return clientService.findClientByEmail(email); }

    @PostMapping("/addClient")
    public Client postClient(@RequestBody Client client) { return clientService.saveClient(client); }

    @PostMapping("/addClients")
    public List<Client> postClients(@RequestBody List<Client> clients) { return clientService.saveClients(clients); }

    @DeleteMapping("/deleteCliet/id/{id}")
    public String deleteClient(@PathVariable int id) { return clientService.removeById(id); }

    @PutMapping("/client/update/{id}")
    public Client putClient(@RequestBody Client client) { return clientService.updateClient(client); }

}
