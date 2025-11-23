package org.example.bankprojet.Reposetories;

import org.example.bankprojet.Entities.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompteEpargne extends JpaRepository<CompteEpargne, Long> {
}
