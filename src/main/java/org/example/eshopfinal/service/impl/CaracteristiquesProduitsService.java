package org.example.eshopfinal.service.impl;

import java.util.List;

import org.example.eshopfinal.entities.CaracteristiquesProduits;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;



@Service
public interface CaracteristiquesProduitsService {
    CaracteristiquesProduits ajoutercaract(CaracteristiquesProduits car);
    void supprimercaract( Long codecar) throws ChangeSetPersister.NotFoundException;
    void updatecaract(Long codecar, CaracteristiquesProduits car);
    List <CaracteristiquesProduits> getAllCract();

}
