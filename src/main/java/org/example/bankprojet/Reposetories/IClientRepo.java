package org.example.bankprojet.Reposetories;

import org.example.bankprojet.Entities.Client;
import org.example.bankprojet.Entities.CompteBancaire;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepo extends JpaRepository<Client, Long> {
    List<Client> findByNameContains(String name);
}
