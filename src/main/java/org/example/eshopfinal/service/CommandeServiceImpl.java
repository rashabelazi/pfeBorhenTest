package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Commande;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    CommandeRepository Repcmd;

    @Override
    public List<Commande> getAllcommande()
    {
        return (List<Commande>)Repcmd.findAll();
    }

    @Transactional
    @Override
    public void validercommande(Long idcmd) {
        Commande commandeToFlag = Repcmd.findById(idcmd).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"User existe pas dans la bd")

        );
        commandeToFlag.setFlag(true);
    }


}
