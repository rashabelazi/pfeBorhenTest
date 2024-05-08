package org.example.eshopfinal.repository;

import org.example.eshopfinal.entities.UserInfo;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends RefreshableCRUDRepository<UserInfo, Long> {

    public UserInfo findByUsername(String username);
    UserInfo findFirstById(Long id);

}
