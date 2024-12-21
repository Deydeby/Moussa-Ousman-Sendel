package com.example.core.repositories.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.core.Repository.RepositoryDb;
import com.example.core.data.entities.Client;
import com.example.core.repositories.interfaces.IClientRepo;

public class ClientRepositoryDB extends RepositoryDb<Client> implements IClientRepo{
    
    public ClientRepositoryDB() {
        super("clients", Client.class);
    }
    
    @Override
    public void insert(Client data) {
        String sql = "INSERT INTO " + tableName + " (surname, telephone, address) VALUES (?, ?, ?)";
        this.getConnection();

        try (PreparedStatement ps = this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, data.getSurname());
            ps.setString(2, data.getTelephone());
            ps.setString(3, data.getAddress());

            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected == 0) {
                System.out.println("L'insertion du client a échoué, aucune ligne insérée.");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    data.setId(rs.getInt(1));
                    System.out.println("ID généré pour le client : " + data.getId());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public List<Client> select() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;

        this.getConnection(); // Obtenir la connexion
        try (PreparedStatement ps = this.connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                try {
                    clients.add(convertToObject(rs));
                } catch (IllegalAccessException ex) {
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection(); // Fermer la connexion après utilisation
        }
        return clients;
    }

    @Override
    public Client findClientById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
