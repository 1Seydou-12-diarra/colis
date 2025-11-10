package com.gestion.gestion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColisDto {
    private Long id;
    private String description;
    private double poids;
    private Long livraisonId;
}

