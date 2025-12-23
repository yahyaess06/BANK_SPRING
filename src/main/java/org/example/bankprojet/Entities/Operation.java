package org.example.bankprojet.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Operation {
    @Id

    private String id;
    private LocalDate dateOp;
    private Double montant;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "compteBancaire_id")
    private CompteBancaire compteBancaire;

    @Enumerated(EnumType.STRING)
    private TypeOp type_operation;
}
