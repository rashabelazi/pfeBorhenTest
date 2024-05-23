package org.example.eshopfinal.entities.security;

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
    private String label;
    private Boolean flag;
    @OneToMany
    @JoinColumn(name="idRole")
    private List<User> user;



}