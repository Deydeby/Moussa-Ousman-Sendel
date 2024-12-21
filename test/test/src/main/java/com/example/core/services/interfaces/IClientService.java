package com.example.core.services.interfaces;

import java.util.List;

import com.example.core.data.entities.Client;

public interface IClientService {
    List<Client> getAll();
    void store(Client client);
}
