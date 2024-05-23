package org.example.eshopfinal.service.impl;

import org.example.eshopfinal.entities.Categorie;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategorieService {
    Categorie AjouterCategorie(Categorie categ);
    List<Categorie> getAllCategorie();
    void UpdateCategorie(Long idcateg,Categorie categ);
    void supprimerCategorie(Long idcateg) throws ChangeSetPersister.NotFoundException;

}
