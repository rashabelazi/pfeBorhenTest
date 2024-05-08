package org.example.eshopfinal.service;

import java.util.List;

import org.example.eshopfinal.entities.Marque;
import org.springframework.stereotype.Service;



@Service
public interface MarqueService {
    Marque AjouterMarque(Marque m);
    void desactivermarque(Long idm);
    void updatemarque(Long idm , Marque m);
    List <Marque> getAllmarque();

}
