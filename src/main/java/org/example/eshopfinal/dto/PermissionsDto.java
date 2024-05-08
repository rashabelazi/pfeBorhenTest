package org.example.eshopfinal.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PermissionsDto {
    private Long idper;
    private String typeper;
    private boolean flag;
}
