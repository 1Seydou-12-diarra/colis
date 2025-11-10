package com.gestion.gestion.controller;


import com.gestion.gestion.dto.ColisDto;
import com.gestion.gestion.entity.Colis;
import com.gestion.gestion.service.ColisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colis")
@RequiredArgsConstructor
public class ColisController {

    private final ColisService colisService;

    @PostMapping
    public Colis creer(@RequestBody ColisDto colisDto) {
        return colisService.save(colisDto); }

    @GetMapping
    public List<Colis> lire() {
        return colisService.getAllColis(); }
}
