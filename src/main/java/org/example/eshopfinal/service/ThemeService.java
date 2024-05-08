package org.example.eshopfinal.service;

import org.example.eshopfinal.entities.Theme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeService {
    Theme AjouterTheme (Theme t);
    List <Theme> getAllTheme();
    void UpdateTheme(Long idtheme, Theme t);
    void DesactiverTheme(Long idtheme);




}

