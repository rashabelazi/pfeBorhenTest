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
@Table
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  Long id;
    private String libr;
    private Boolean FLAG;

    @OneToMany
    private List<UserInfo> u;

    @OneToMany
    private List<Permission> permissions;

}