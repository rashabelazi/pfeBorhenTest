package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.CaracteristiquesProduits;
import org.example.eshopfinal.service.CaracteristiquesProduitsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.example.eshopfinal.service.CaracteristiquesProduitsService;

import java.util.List;

@RestController
@RequestMapping("api/v1/caracteristique")
@RequiredArgsConstructor
public class CaracteristiqueController {



    @Autowired
    CaracteristiquesProduitsServiceImpl caractProduitService;

    @GetMapping
    public List<CaracteristiquesProduits> GetAllCaract(){
        List<CaracteristiquesProduits> list=caractProduitService.getAllCract();
        return list;
    }
    @PostMapping("/add")
    public CaracteristiquesProduits AjouterCaract(@RequestBody CaracteristiquesProduits car){
        return  caractProduitService.ajoutercaract(car);
    }
    @PutMapping("/{id}")
    public void DesactiverCaract(@PathVariable Long id){
        caractProduitService.desactivercaract(id);

    }
    @PutMapping("/{id}")
    public void UpdateCaract(@PathVariable Long id,@RequestBody CaracteristiquesProduits car){
        caractProduitService.updatecaract(id,car);
    }
}

