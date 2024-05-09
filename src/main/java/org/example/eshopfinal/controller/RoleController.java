package org.example.eshopfinal.controller;

import lombok.AllArgsConstructor;
import org.example.eshopfinal.entities.Role;
import org.example.eshopfinal.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/role")
public class RoleController {

    private final RoleService roleService;



    @GetMapping
    public List<Role> getAllRole(){
        List<Role> list= roleService.getAllRole();
        return  list;
    }

    @PostMapping("/add")
    public Role AjouterRole(@RequestBody Role r){
        return roleService.Ajouterrole(r);
    }

    @PutMapping("/{id}")
    public void FlagRole(@PathVariable Long id){
        roleService.FlagRole(id);}

    @PutMapping("/{id}")
    public void UpdateRole(@PathVariable Long id,@RequestBody Role r) {
        roleService.updaterole(r,id);}


}