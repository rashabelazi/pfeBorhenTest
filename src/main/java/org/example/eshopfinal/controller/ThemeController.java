package org.example.eshopfinal.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.eshopfinal.service.ThemeService;

import java.util.List;

@RequestMapping("api/v1/theme")
@RestController
@RequiredArgsConstructor
public class ThemeController {
    @Autowired

    ThemeService themeService;
    @GetMapping
    public List<Theme> getAllTheme(){
        List<Theme> list=themeService.getAllTheme();
        return list;
    }
    @PostMapping("/add")
    public Theme AjouterTheme(@RequestBody Theme t) {
        return themeService.AjouterTheme(t);

    }

    @PutMapping("/{id}")
    public void FlagTheme(@PathVariable Long id){
        themeService.DesactiverTheme(id);
    }

    @PutMapping("update/{id}")
    public void UpdateTheme(@PathVariable Long id, Theme t){
        themeService.UpdateTheme(id,t);
    }


}
