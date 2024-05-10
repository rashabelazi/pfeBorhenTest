package org.example.eshopfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  Long id;
    private String libr;
    private Boolean FLAG;



    @OneToMany
    @JoinColumn(name="idRole")
    private List<UserInfo> user;

    @OneToMany
    private List<Permission> permissions;

}