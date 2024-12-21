package com.example.core.data.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
    int nb;
    int id;
    String surname;
    String telephone;
    String address;

    public Client(String surname, String telephone, String address) {
        this.id = nb++;
        this.surname = surname;
        this.telephone = telephone;
        this.address = address;
    }

    public Client(){

    }
    
}
