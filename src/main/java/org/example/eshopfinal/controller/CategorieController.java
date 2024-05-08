package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Categorie;
import org.example.eshopfinal.service.CategorieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/categorie")
@RequiredArgsConstructor
public class CategorieController {
    @Autowired
    CategorieServiceImpl categorieService;
    @GetMapping
    public List<Categorie> getAllCategorie() {
        List<Categorie> list = categorieService.getAllCategorie();
        return list;
    }
    @PostMapping("/add")
    public Categorie AjouterCategorie(@RequestBody Categorie categ){
        return categorieService.AjouterCategorie(categ);
    }
    @PostMapping("/{id}")
    public  void UpdateCateg(@PathVariable Long id, @RequestBody Categorie categ){
        categorieService.UpdateCategorie(id, categ);

    }
}
