package org.example.bankprojet.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOaffichageb {
    private String id;
    private Date dateCreation;
    private Double sold;
    private String devise;
    private Double decouvert;
    private Double tauxInteret;
}
