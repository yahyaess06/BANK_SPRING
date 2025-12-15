package org.example.bankprojet.Reposetories;

import org.example.bankprojet.Entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOperationRepo extends JpaRepository<Operation, String> {
    List<Operation> findByCompteBancaireId(String compteBancaireId);
}
