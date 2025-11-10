package com.gestion.gestion.controller;

import com.gestion.gestion.dto.ClientDto;
import com.gestion.gestion.entity.Client;
import com.gestion.gestion.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @PostMapping
    public Client creer(@RequestBody ClientDto clientDto) {
        return clientService.save(clientDto); }


    @GetMapping
    public List<Client> lire() {
        return clientService.findAll();
    }

    @PutMapping
    public Client update(@RequestBody ClientDto clientDto) {
        return clientService.update(clientDto);
    }


}
