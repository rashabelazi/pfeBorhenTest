package org.example.eshopfinal.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.entities.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.example.eshopfinal.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

     private final RoleRepository RepRole;



    @Override
    public Role Ajouterrole(Role r) {
        RepRole.save(r);
        return r;
    }

    @Transactional
    @Override
    public void updaterole(Role r, long idr) {
        Role roleToUpdate = RepRole.findById(idr).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"role existe pas dans la base de données")
        );
        if(r.getLibr()!= null && !r.getLibr().isEmpty()){
            roleToUpdate.setLibr(r.getLibr());

        }

    }


    @Transactional
    @Override
    public void FlagRole(Long idr) {
        Role roleToFlag = RepRole.findById(idr).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Role existe pas dans la bd")
        );
        roleToFlag.setFLAG(true);
    }


    @Override
    public List<Role> getAllRole() {
        return (List<Role>) RepRole.findAll();
    }


    @Override
    public Role getRoleById(Long idr) {
        return RepRole.findById(idr).orElse
                (null);


    }
}

