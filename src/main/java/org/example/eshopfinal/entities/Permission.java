package org.example.eshopfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table

public class Permission {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idper;
    private String typeper;
    private boolean flag;



    @OneToOne
    private Role role;
}
