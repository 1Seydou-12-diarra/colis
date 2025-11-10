package com.gestion.gestion.controller;


import com.gestion.gestion.dto.LivraisonDto;
import com.gestion.gestion.entity.Livraison;
import com.gestion.gestion.entity.StatutLivraison;
import com.gestion.gestion.service.LivraisonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livraisons")
@RequiredArgsConstructor
public class LivraisonController {

    private final LivraisonService livraisonService;

    /**
     * creer une livraison
     * */
    @PostMapping
    public Livraison creer(@RequestBody LivraisonDto dto) {
        return livraisonService.creerLivraison(dto);
    }

    /**
     * mise à jour du statut
     * */
    @PutMapping("{id}/statut")
    public Livraison majStatut(@PathVariable Long id, @RequestParam StatutLivraison statut) {
        return livraisonService.majStatut(id, statut);
    }




    /**
     * recherche de toute les livraison d'un client
     * */

    @GetMapping("/client/{clientId}")
    public List<Livraison> getByClient(@PathVariable Long clientId) {
        return livraisonService.getLivraisonsClient(clientId);
    }

    /**
     * assigner un chauffeur a une livraison
     * */
    @PostMapping("/{livraisonId}/assigner-chauffeur/{chauffeurId}")
    public Livraison assignerChauffeur(@PathVariable Long livraisonId, @PathVariable Long chauffeurId) {
        return livraisonService.assignerChauffeur(livraisonId, chauffeurId);
    }

}