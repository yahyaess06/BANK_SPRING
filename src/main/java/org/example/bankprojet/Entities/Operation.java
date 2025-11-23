package org.example.bankprojet.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOp;
    private Double montant;
    private TypeOp type;

    @ManyToOne
    @JoinColumn(name = "compteBancaire_id")
    private CompteBancaire compteBancaire;

    @Enumerated(EnumType.STRING)
    private TypeOp type_operation;
}
