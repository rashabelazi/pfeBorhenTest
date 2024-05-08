package org.example.eshopfinal.service;

import org.example.eshopfinal.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.CategorieRepository;

import java.util.List;
@Service
public class CategorieServiceImpl implements  CategorieService{
    @Autowired
    CategorieRepository RepCateg;
    @Override
    public Categorie AjouterCategorie(Categorie categ) {
        RepCateg.save(categ);
        return categ;
    }

    @Override
    public List<Categorie> getAllCategorie() {

        return (List<Categorie>) RepCateg.findAll();
    }

    @Override
    public void UpdateCategorie(Long idcateg, Categorie categ) {
        Categorie CategorieToUpdate = RepCateg.findById(idcateg).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"categorie existe pas dans la bd")

        );
        if(categ.getLibcateg()!=null &&!categ.getLibcateg().isEmpty()){
            CategorieToUpdate.setLibcateg(categ.getLibcateg());
        }


    }

    @Override
    public void FlagCategorie(Long idcateg) {
        Categorie categorieToFlag = RepCateg.findById(idcateg).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"categorie existe pas dans la bd")

        );
        categorieToFlag.setFlag(true);

    }
}
