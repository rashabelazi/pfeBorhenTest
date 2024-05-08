package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.CaracteristiquesProduits;
import org.springframework.stereotype.Service;



@Service
public interface CaracteristiquesProduitsService {
    CaracteristiquesProduits ajoutercaract(CaracteristiquesProduits car);
    void desactivercaract( Long codecar);
    void updatecaract(Long codecar, CaracteristiquesProduits car);
    List <CaracteristiquesProduits> getAllCract();

}
