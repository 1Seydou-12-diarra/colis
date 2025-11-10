package com.gestion.gestion.service;

import com.gestion.gestion.dto.ColisDto;
import com.gestion.gestion.entity.Colis;
import com.gestion.gestion.entity.Livraison;
import com.gestion.gestion.repository.ColisRepository;
import com.gestion.gestion.repository.LivraisonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColisService {

    private final ColisRepository colisRepository;
    private final LivraisonRepository livraisonRepository;

    public ColisService(ColisRepository colisRepository, LivraisonRepository livraisonRepository) {
        this.colisRepository = colisRepository;
        this.livraisonRepository = livraisonRepository;
    }

    /**
     * enregistrement  des colis de livraison
     * */

    public Colis save(ColisDto colisDto) {
        Colis colis = new Colis();
        colis.setDescription(colisDto.getDescription());
        colis.setPoids(colisDto.getPoids());
        colis.setLivraison(livraisonRepository.findById(colisDto.getLivraisonId()).orElseThrow());

        return colisRepository.save(colis);
    }



    /**
    * liste des colis de livraison
    * */
    public List<Colis> getAllColis() {
        return colisRepository.findAll();
    }

}
