package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository  extends CrudRepository<Categorie,Long> {

}
