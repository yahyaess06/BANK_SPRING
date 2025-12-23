package org.example.bankprojet.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bankprojet.Entities.TypeOp;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpeDto {
    private String id;
    private LocalDate dateOp;
    private Double montant;
    private TypeOp type_operation;
}
