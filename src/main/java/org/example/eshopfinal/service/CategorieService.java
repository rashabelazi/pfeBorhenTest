package org.example.eshopfinal.service;

import org.example.eshopfinal.entities.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategorieService {
    Categorie AjouterCategorie(Categorie categ);
    List<Categorie> getAllCategorie();
    void UpdateCategorie(Long idcateg,Categorie categ);
    void FlagCategorie(Long idcateg);

}
