package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Marque;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.MarqueRepository;

@Service
public class MarqueServiceImpl implements MarqueService {
    @Autowired
    MarqueRepository RepMarque;
    @Override
    public Marque AjouterMarque(Marque m) {
        RepMarque.save(m);
        return m;
    }

    @Transactional
    @Override
    public void desactivermarque(Long idm) {
        Marque marqueToFlag = RepMarque.findById(idm).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"marque existe pas dans la bd")

        );
        marqueToFlag.setFlag(true);

    }

    @Override
    public void updatemarque(Long idm, Marque m) {
        Marque marqueToUpdate = RepMarque.findById(idm).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"marque existe pas dans la base de données")
        );
        if(m.getLibm()!= null && !m.getLibm().isEmpty()){
            marqueToUpdate.setLibm(m.getLibm());

        }
        if(m.getDescription()!=null && !m.getDescription().isEmpty()){
            marqueToUpdate.setDescription(m.getDescription());
        }




    }

    @Override
    public List<Marque> getAllmarque() {

        return (List<Marque>) RepMarque.findAll();
    }
}