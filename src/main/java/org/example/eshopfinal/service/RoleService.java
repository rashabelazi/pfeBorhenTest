package org.example.eshopfinal.service;

import org.example.eshopfinal.entities.Role;

import java.util.List;


public interface RoleService {
    Role Ajouterrole(Role r);
    void updaterole( Role r , long idr);
    Role FlagRole(Long idr);
    List <Role> getAllRole();
    Role getRoleById(Long idr);

}
