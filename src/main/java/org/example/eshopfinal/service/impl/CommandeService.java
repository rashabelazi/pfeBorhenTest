package org.example.eshopfinal.service.impl;

import java.util.Date;
import java.util.List;

import org.example.eshopfinal.entities.Commande;
import org.springframework.stereotype.Service;



@Service
public interface CommandeService {
    List <Commande> getAllcommande();
    void validercommande(Long idcmd );

    Commande getCommandeById(Long id);
    List <Commande> getCommandeByEtat(String etatCmd);
    List<Commande> getCommandeByDateCreation(Date datecmd);


}