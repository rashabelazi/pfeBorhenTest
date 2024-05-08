package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    ProduitRepository RepProduit;

    @Override
    public Produit ajouterproduit(Produit p) {
        RepProduit.save(p);
        return p;
    }

    @Override
    public void updateproduit(Produit p,Long idprod) {
        Produit produitToUpdate = RepProduit.findById(idprod).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"produit existe pas dans la base de données")

        );
        if(p.getNomprod()!=null && !p.getNomprod().isEmpty()){
            produitToUpdate.setNomprod(p.getNomprod());
        }
        if(p.getDescription()!=null && !p.getDescription().isEmpty()){
            produitToUpdate.setDescription(p.getDescription());
        }
        if(p.getPrix()== Float.parseFloat(null)){
            produitToUpdate.setPrix(p.getPrix());
        }
        if(p.getReference()!=null ){
            produitToUpdate.setReference(p.getReference());
        }


    }

    @Override
    public void desactiverproduit(Long idprod) {
        Produit produitToFlag = RepProduit.findById(idprod).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"produit existe pas dans la bd")

        );
        produitToFlag.setFlag(true);


    }

    @Override
    public List<Produit> getAllProduit() {

        return (List<Produit>)RepProduit.findAll();
    }
}
