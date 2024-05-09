package org.example.eshopfinal.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idprod")
    private Long idprod;
    private String nomprod;
    private Integer reference;
    private float prix;
    private Date date =new Date();
    private String description;
    private Boolean flag;

    @ManyToOne
    @JoinColumn(name="idm")
    private Marque m;

    @OneToMany
    private List<Stock> stock;

    @ManyToOne
    @JoinColumn(name="idgateg")
    private Categorie categorie;


    @ManyToMany
    private  List<UserInfo> userEntityList;

    @ManyToMany
    private List<Commande> commandes;





}

