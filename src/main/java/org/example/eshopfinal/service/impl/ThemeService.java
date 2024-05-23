package org.example.eshopfinal.service.impl;

import org.example.eshopfinal.entities.Theme;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeService {
    Theme AjouterTheme (Theme t);
    List <Theme> getAllTheme();
    void UpdateTheme(Long idtheme, Theme t);
    void SupprimerTheme(Long idtheme) throws ChangeSetPersister.NotFoundException;




}

