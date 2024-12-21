package com.example.core.views;

import java.util.List;
import java.util.Scanner;

import com.example.core.data.entities.Client;
import com.example.core.services.ClientService;
import com.example.core.views.interfaces.IClientView;

public class ClientView implements IClientView{
    
    Scanner scanner = new Scanner(System.in);
    ClientService clientService;
    public ClientView(ClientService clientService) {
        this.clientService = clientService;
    }
    @Override
    public void lister(){
        List<Client> listerClients = this.clientService.getAll();
        if(listerClients.isEmpty()){
            System.out.println("Aucun client trouvé");
        }

        for (Client client : listerClients) {
            System.out.println("L'id du client : " + client.getId());
            System.out.println("Le nom du client : " + client.getSurname());
            System.out.println("L'adresse du client : " + client.getAddress());
            System.out.println("Le telephone du client : " + client.getTelephone());
        }
    }

    @Override
    public void ajout(){
        System.out.println("Renseignez le surname : ");
        String surname = scanner.nextLine();

        System.out.println("Renseignez le telephone : ");
        String telephone = scanner.nextLine();

        System.out.println("Renseignez l'adresse : ");
        String address = scanner.nextLine();

        Client client = new Client(surname, telephone, address);

        clientService.store(client);

    }
}
