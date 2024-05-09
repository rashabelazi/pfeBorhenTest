package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Marque;
import org.example.eshopfinal.service.MarqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/marque")
@RequiredArgsConstructor
public class MarqueController {

    @Autowired
    MarqueServiceImpl MarqueService;
    @GetMapping

    public List<Marque> getAllMarques(){
        List<Marque> list=MarqueService.getAllmarque();
        return list;

    }
    @PostMapping("/add")
    public Marque AjouterMarque(@RequestBody Marque m){
        return MarqueService.AjouterMarque(m);
    }
    @PutMapping("/{id}")
    public void FlagMarque(@PathVariable Long id)
    {
        MarqueService.desactivermarque(id);
    }
    @PutMapping("update/{id}")
    public void UpdateMarque(@PathVariable Long id, @RequestBody Marque m)
    {
        MarqueService.updatemarque(id,m);
    };



}

