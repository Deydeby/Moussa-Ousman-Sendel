package com.example.core.repositories;

import com.example.core.Repository.Repository;
import com.example.core.data.entities.Client;
import com.example.core.repositories.interfaces.IClientRepo;

public class ClientRepository extends Repository<Client> implements IClientRepo{

    @Override
    public Client findClientById(int id) {
        for (Client client : data) {
            if(client.getId()==id){
                return client;
            }
            
        }
        return null;
    }
    

}
