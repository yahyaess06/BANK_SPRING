package org.example.bankprojet.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cbdto {
    private Long id;  //id client
    private String type;
    private Double sold;
    private String devise;
    private Double decouvert;
    private Double tauxInteret;
}
