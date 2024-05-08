package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends CrudRepository<Role, Long>{

}
