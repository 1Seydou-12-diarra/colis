package com.gestion.gestion.dto;


import com.gestion.gestion.entity.StatutLivraison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivraisonDto {
    private Long id;
    private String adresseLivraison;
    private StatutLivraison statut;
    private Long clientId;
    private Long chauffeurId;
}
