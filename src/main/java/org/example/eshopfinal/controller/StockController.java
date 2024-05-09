package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Stock;
import org.example.eshopfinal.service.StockServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/stock")
@RequiredArgsConstructor
public class StockController {
    StockServiceImpl StockService;

    @GetMapping

    public List<Stock> getAllstock(){
        List<Stock> list= StockService.getallstock();
        return list;
    }
    @PostMapping("/add")
    public  Stock AjouterStock(@RequestBody Stock s){
        return StockService.Ajouterstock(s);
    }
    @PutMapping("/{id}")
    public void FlagStock(@PathVariable Long id) {
        StockService.flagstock(id);}

    @PutMapping("/{id}")
    public void UpdateStock(@PathVariable Long id,@RequestBody Stock s){
        StockService.updatestock(id,s);}

}
