package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.CaracteristiquesProduits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CaracteristiquesProduitsRepository  extends CrudRepository <CaracteristiquesProduits, Long>{

}
