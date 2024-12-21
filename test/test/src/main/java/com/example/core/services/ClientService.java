package com.example.core.services;

import java.util.List;

import com.example.core.data.entities.Client;
import com.example.core.repositories.interfaces.IClientRepo;
import com.example.core.services.interfaces.IClientService;

public class ClientService implements IClientService {

    IClientRepo clientRepository;

    public ClientService(IClientRepo clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.select();
    }

    @Override
    public void store(Client client) {
        clientRepository.insert(client);
    }
}
