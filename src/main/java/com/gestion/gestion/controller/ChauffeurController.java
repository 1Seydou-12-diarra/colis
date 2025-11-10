package com.gestion.gestion.controller;

import com.gestion.gestion.dto.ChauffeurDto;
import com.gestion.gestion.entity.Chauffeur;
import com.gestion.gestion.service.ChauffeurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chauffeurs")
@RequiredArgsConstructor
public class ChauffeurController {

    private final ChauffeurService chauffeurService;

    @PostMapping
    public Chauffeur creer(@RequestBody ChauffeurDto chauffeurDto) { return chauffeurService.save(chauffeurDto);
    }

    @GetMapping
    public List<Chauffeur> lire() {
        return chauffeurService.findAll();
    }

}
