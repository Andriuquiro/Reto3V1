package com.example.demo.Servicio;

import com.example.demo.Modelo.Client;
import com.example.demo.Repositorio.ClientRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServicio {

    @Autowired
    private ClientRepositorio clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId) {
        return clientRepository.getClient(clientId);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> client1 = clientRepository.getClient(client.getIdClient());
            if (client1.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
}
