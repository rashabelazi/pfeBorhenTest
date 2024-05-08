package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}

