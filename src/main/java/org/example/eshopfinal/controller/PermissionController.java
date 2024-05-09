package org.example.eshopfinal.controller;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.eshopfinal.service.PermissionService;

import java.util.List;

@RestController
@RequestMapping("api/v1/permission")
@RequiredArgsConstructor
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @GetMapping
    public List<Permission> getAllPermission(){
        List<Permission> list=permissionService.getAllPermission();
        return list;
    }
    @PostMapping("/add")
    public Permission AjouterPermission(@RequestBody Permission p){
        return permissionService.AjouterPermission(p);
    }
    @PutMapping("/{id}")
    public void FlagPermission(@PathVariable Long id){

        permissionService.FlagPermission(id);
    }
    @PutMapping("/{id}")
    public void updatePermission(@PathVariable Long id,@RequestBody Permission p){
        permissionService.UpdatePermission(id,p);
    }
}

