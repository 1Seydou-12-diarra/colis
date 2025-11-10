package com.gestion.gestion.service;

import com.gestion.gestion.dto.ChauffeurDto;
import com.gestion.gestion.entity.Chauffeur;
import com.gestion.gestion.repository.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChauffeurService {
    @Autowired
    private ChauffeurRepository chauffeurRepository;

    public ChauffeurService(ChauffeurRepository chauffeurRepository) {
        this.chauffeurRepository = chauffeurRepository;
    }
    /***
     * lits de tous les clients
     */

    public List<Chauffeur> findAll() {
        return chauffeurRepository.findAll();
    }

   public Chauffeur findById(Long id) {
        return chauffeurRepository.findById(id).get();
   }

   public Chauffeur save(ChauffeurDto chauffeurDto) {
        Chauffeur chauffeur = new Chauffeur();
        chauffeur.setNom(chauffeurDto.getNom());
        chauffeur.setTelephone(chauffeurDto.getTelephone());
        return chauffeurRepository.save(chauffeur);
       }



}
