package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.Categorie;
import org.example.eshopfinal.entities.Couleur;
import org.example.eshopfinal.entities.Marque;
import org.example.eshopfinal.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {


// Optional<Produit> findProduitByMarque(Marque marque);
//
// Optional<Produit>findProduitByCategorie(Categorie categorie);
//
// Optional<Produit>findProduitByCouleur(Couleur couleur);


}