package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Couleur;
import org.example.eshopfinal.service.CouleurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/couleur")
@RequiredArgsConstructor

public class CouleurController {
    @Autowired
    CouleurServiceImpl CouleurService;
    @GetMapping
    public List<Couleur> getAllCouleur(){
        List<Couleur> list=CouleurService.getAllcouleur();
        return  list;
    }
    @PostMapping("/add")
    public Couleur AjouterCouleur(@RequestBody Couleur c){
        return CouleurService.ajoutercouleur(c);
    }
    @PutMapping("/{id}")
    public void DesactiverCouleur(@PathVariable String id) {
        CouleurService.desactiver(id);

    }
    @PutMapping("/{id}")
    public void UpdateCouleur(@PathVariable String id, @RequestBody Couleur c){
        CouleurService.updatecouleur(id,c);
    }
}

