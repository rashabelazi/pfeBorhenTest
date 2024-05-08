package org.example.eshopfinal.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Produit;
import org.example.eshopfinal.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/produit")
@RequiredArgsConstructor
public class ProduitController {
    @Autowired
    ProduitService produitService;

    @GetMapping

    public List<Produit> getAllProduit() {
        List<Produit> list = produitService.getAllProduit();
        return list;
    }
    @PostMapping("/add")
    public Produit AjouterProduit(@RequestBody Produit p){
        return  produitService.ajouterproduit(p);
    }
    @DeleteMapping("/{id}")
    public void FlagProduit(@PathVariable Long id){
        produitService.desactiverproduit(id);}

    @PutMapping("/{id}")
    public void UpdateProduit( @RequestBody Produit p , @PathVariable Long id){
        produitService.updateproduit(p,id);}



}
