package org.example.bankprojet.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@DiscriminatorValue("CompteEpargne")
public class CompteEpargne extends CompteBancaire{

    private double tauxInteret;
}
