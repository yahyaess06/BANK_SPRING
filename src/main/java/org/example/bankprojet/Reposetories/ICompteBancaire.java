package org.example.bankprojet.Reposetories;

import org.example.bankprojet.Entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompteBancaire extends JpaRepository<CompteBancaire, Long> {
}
