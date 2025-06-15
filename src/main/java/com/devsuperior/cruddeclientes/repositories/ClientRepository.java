package com.devsuperior.cruddeclientes.repositories;

import com.devsuperior.cruddeclientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
