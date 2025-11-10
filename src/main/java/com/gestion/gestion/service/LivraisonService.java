package com.gestion.gestion.service;

import com.gestion.gestion.dto.LivraisonDto;
import com.gestion.gestion.entity.Chauffeur;
import com.gestion.gestion.entity.Livraison;
import com.gestion.gestion.entity.StatutLivraison;
import com.gestion.gestion.repository.ChauffeurRepository;
import com.gestion.gestion.repository.ClientRepository;
import com.gestion.gestion.repository.LivraisonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivraisonService {

    private final LivraisonRepository livraisonRepository;
    private final ClientRepository clientRepository;
    private final ChauffeurRepository chauffeurRepository;


    /**
     *
     // Créer une livraison
     */
    public Livraison creerLivraison(LivraisonDto dto) {
        Livraison livraison = new Livraison();
        livraison.setAdresseLivraison(dto.getAdresseLivraison());
        livraison.setStatut(StatutLivraison.EN_PREPARATION);
        livraison.setClient(clientRepository.findById(dto.getClientId()).orElseThrow());
        livraison.setChauffeur(chauffeurRepository.findById(dto.getChauffeurId()).orElseThrow());
        return livraisonRepository.save(livraison);
    }

    /**
     *
     Mettre à jour le statut
     */

    public Livraison majStatut(Long id, StatutLivraison statut) {
        Livraison l = livraisonRepository.findById(id).orElseThrow();
        l.setStatut(statut);
        return livraisonRepository.save(l);
    }

    /**
     *
    Rechercher livraisons d’un client
     */
    public List<Livraison> getLivraisonsClient(Long clientId) {
        return livraisonRepository.findByClientId(clientId);
    }

    /***
     * assigner un chauffeur a une livraison
     */

    public Livraison assignerChauffeur(Long livraisonId, Long chauffeurId) {
        Livraison livraison = livraisonRepository.findById(livraisonId)
                .orElseThrow(() -> new RuntimeException("Livraison non trouvée"));

        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId)
                .orElseThrow(() -> new RuntimeException("Chauffeur non trouvé"));

        livraison.setChauffeur(chauffeur);
        return livraisonRepository.save(livraison);
    }
}
