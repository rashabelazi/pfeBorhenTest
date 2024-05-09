package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Commande;
import org.springframework.stereotype.Service;



@Service
public interface CommandeService {
    List <Commande> getAllcommande();
    void validercommande(Long idcmd );

    Commande getCommandeById(Long id);


}