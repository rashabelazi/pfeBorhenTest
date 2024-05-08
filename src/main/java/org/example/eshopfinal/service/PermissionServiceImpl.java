package org.example.eshopfinal.service;


import org.example.eshopfinal.entities.Permission;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.PermissionRepository;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    PermissionRepository RepPermission;
    @Override
    public Permission AjouterPermission(Permission p) {
        RepPermission.save(p);
        return p;
    }

    @Override
    public List<Permission> getAllPermission() {
        return (List<Permission>) RepPermission.findAll();
    }

    @Override
    @Transactional
    public void UpdatePermission(Long idper, Permission p) {
        Permission permissionToUpdate = RepPermission.findById(idper).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"permission existe pas dans la base de données")

        );
        if(p.getTypeper()!=null && !p.getTypeper().isEmpty()){
            permissionToUpdate.setTypeper(p.getTypeper());
        }

    }

    @Override
    @Transactional
    public void FlagPermission(Long idper) {
        Permission permissionToFlag = RepPermission.findById(idper).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"permission existe pas dans la base de données")

        );
        permissionToFlag.setFlag(true);

    }
}
