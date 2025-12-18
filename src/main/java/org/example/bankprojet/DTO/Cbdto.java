package org.example.bankprojet.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
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
