package org.example.bankprojet.Reposetories;

import org.example.bankprojet.Entities.CompteCourant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompteCourant extends JpaRepository<CompteCourant, Long> {
}
