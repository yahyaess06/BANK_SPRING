package org.example.bankprojet.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Compte_type")
public class CompteBancaire implements Serializable {
@Id
    private String id;
    private Date dateCreation;
    private Double sold;
    private String devise;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "compteBancaire")
    private List<Operation> operations;

    @Enumerated(EnumType.STRING)
    private StatCompte status;

}
