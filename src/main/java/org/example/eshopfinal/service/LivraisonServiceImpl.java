//package org.example.eshopfinal.service;
/*
import java.util.List;

import org.example.eshopfinal.entities.Livraison;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.LivraisonRepository;

@Service
public class LivraisonServiceImpl implements LivraisonService {
    @Autowired
    LivraisonRepository RepLiv;

    @Override
    public Livraison ajouterlivraison(Livraison l) {
        RepLiv.save(l);
        return l;
    }

    @Transactional
    @Override
    public void desactiverlivraison(Long idliv) {
        Livraison livraisonToFlag = RepLiv.findById(idliv).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"livraison existe pas dans la bd")

        );
        livraisonToFlag.setFlag(true);

    }

    @Override
    public void updatelivraison(Long idliv, Livraison l) {
        Livraison livraisonToUpdate = RepLiv.findById(idliv).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"livraison existe pas dans la base de données")

        );
        if(l.getTypeliv()!=null && !l.getTypeliv().isEmpty()){
            livraisonToUpdate.setTypeliv(l.getTypeliv());
        }

    }

    @Override
    public List<Livraison> getAlllivraison() {
        return (List<Livraison>) RepLiv.findAll();
    }
}


 */