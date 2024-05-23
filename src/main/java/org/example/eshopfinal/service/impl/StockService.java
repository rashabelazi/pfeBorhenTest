package org.example.eshopfinal.service.impl;

import org.example.eshopfinal.entities.Stock;

import java.util.List;



public interface StockService {
    Stock Ajouterstock(Stock s);
    void flagstock(Long idstck);
    List <Stock> getallstock();
    void updatestock(Long idstck, Stock s);


}
