package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.Role;
import org.example.eshopfinal.entities.UserInfo;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends RefreshableCRUDRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);
    UserInfo findFirstById(Long id);

   // UserInfo findByRole(Role role);
}
