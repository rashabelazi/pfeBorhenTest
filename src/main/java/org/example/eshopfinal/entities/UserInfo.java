package org.example.eshopfinal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String mail;
    private boolean flag;
    private Integer numTel;

    @ManyToOne
    @JoinColumn(name="idRole")
    private Role roles ;

    @ManyToMany
    private List<Produit> produits;



}