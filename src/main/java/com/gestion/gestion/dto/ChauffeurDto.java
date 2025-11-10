package com.gestion.gestion.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChauffeurDto {
    private Long id;
    private String nom;
    private String telephone;
}
