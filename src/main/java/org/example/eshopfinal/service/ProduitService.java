package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Produit;
import org.springframework.stereotype.Service;


@Service
public interface ProduitService {
    Produit ajouterproduit(Produit p);
    void updateproduit(Produit p,Long idprod);
    void desactiverproduit(Long idprod);
    List <Produit> getAllProduit();

}
