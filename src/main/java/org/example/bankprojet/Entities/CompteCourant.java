package org.example.bankprojet.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@DiscriminatorValue("CompteCourant")
public class CompteCourant extends CompteBancaire{

    private double decouvert;
}
