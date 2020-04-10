package com.nomizo.service;

import com.nomizo.db.ClientRepository;
import com.nomizo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getUsers() { return clientRepository.findAll(); }
    public Client getUserByEmail (String email) { return clientRepository.findByEmail(email); }
    public Client getUserById (int id) { return clientRepository.findById(id).orElse(null); }

    public String deleteById (int id) { clientRepository.deleteById(id); return " User removed !!"+id; }

    public Client saveClient (Client client) { return clientRepository.save(client); }
    public List<Client> saveClient(List<Client> clients) { return clientRepository.saveAll(clients); }

    public Client updateClient(Client client) {
        Client clientUpdate = clientRepository.findById(client.getClientId()).orElse(null);
        clientUpdate.setUsername(client.getUsername());
        clientUpdate.setPassword(client.getPassword());
        return clientRepository.save(clientUpdate);
    }
}
