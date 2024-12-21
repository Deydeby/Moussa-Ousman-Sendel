package com.example.core.data.entities;

import java.time.LocalDate;

import com.example.core.data.Enum.EnumDette;

import lombok.Data;


@Data
public class Dette {
    int nb;
    int id;
    LocalDate date;
    int montant_restant; 
    int montant_total;
    int montant_verser;
    EnumDette enumDette;
    public Dette(LocalDate date, int montant_restant, int montant_total, int montant_verser,EnumDette enumDette) {
        this.id = nb++;
        this.date = date;
        this.montant_restant = montant_restant;
        this.montant_total = montant_total;
        this.montant_verser = montant_verser;
        this.enumDette = enumDette;
    }

}
