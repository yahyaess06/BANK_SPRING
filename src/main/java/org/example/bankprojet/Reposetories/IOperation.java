package org.example.bankprojet.Reposetories;

import org.example.bankprojet.Entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOperation extends JpaRepository<Operation, Long> {
}
