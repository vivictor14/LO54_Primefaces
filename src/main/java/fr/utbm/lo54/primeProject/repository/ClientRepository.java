package fr.utbm.lo54.primeProject.repository;

import fr.utbm.lo54.primeProject.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
