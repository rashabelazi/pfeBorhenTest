package org.example.eshopfinal.service;


import org.example.eshopfinal.entities.Permission;

import java.util.List;

public interface PermissionService {
    Permission AjouterPermission(Permission p);
    List<Permission> getAllPermission();
    void UpdatePermission(Long idper,Permission p);
    void FlagPermission(Long idper);
}

