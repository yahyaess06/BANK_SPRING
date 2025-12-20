package org.example.bankprojet.Reposetories;

import org.example.bankprojet.Entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompteBancaireRepo extends JpaRepository<CompteBancaire, String> {
    void deleteAllByClientId(Long id);
    List<CompteBancaire> findCompteBancaireByClientId(Long clientId);
}
