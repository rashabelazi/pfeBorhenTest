package org.example.eshopfinal.service;


import org.example.eshopfinal.entities.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.ThemeRepository;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeRepository RepTheme;
    @Override
    public Theme AjouterTheme(Theme t) {
        RepTheme.save(t);
        return t;
    }

    @Override
    public List<Theme> getAllTheme() {
        return (List<Theme>) RepTheme.findAll();
    }

    @Override
    public void UpdateTheme(Long idtheme, Theme t) {
        Theme ThemeToUpdate = RepTheme.findById(idtheme).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"theme existe pas dans la bd")

        );
        if(t.getLibtheme()!=null && !t.getLibtheme().isEmpty()){
            ThemeToUpdate.setLibtheme(t.getLibtheme());
        }


    }

    @Override
    public void DesactiverTheme(Long idtheme) {
        Theme ThemeToFlag = RepTheme.findById(idtheme).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"theme existe pas dans la bd")

        );
        ThemeToFlag.setFlag(true);


    }
}
