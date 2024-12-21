package com.example;

import java.util.Scanner;

import com.example.core.repositories.ClientRepository;
import com.example.core.repositories.DB.ClientRepositoryDB;
import com.example.core.repositories.interfaces.IClientRepo;
import com.example.core.services.ClientService;
import com.example.core.views.ClientView;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        IClientRepo clientRepository = new ClientRepository();
        IClientRepo clientRepositoryDB = new ClientRepositoryDB();
        ClientService clientService = new ClientService(clientRepositoryDB);
        ClientView clientView = new ClientView(clientService);
       
        
        do {
            
            System.out.println("1- Créer un client :");
            System.out.println("2- Lister les clients :");
            System.out.println("3- Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    clientView.ajout();
                    break;
                case 2:
                    clientView.lister();
                    break;
    
                default:
                    break;
            }
        } while (choix!=3);

        scanner.close();
        
     }
}