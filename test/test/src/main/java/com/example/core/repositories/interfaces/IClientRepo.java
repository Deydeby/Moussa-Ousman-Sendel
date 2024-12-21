package com.example.core.repositories.interfaces;

import com.example.core.Repository.interfaces.IRepo;
import com.example.core.data.entities.Client;

public interface IClientRepo extends IRepo<Client>{
    Client findClientById(int id);
    
}
