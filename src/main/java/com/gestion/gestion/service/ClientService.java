package com.gestion.gestion.service;

import com.gestion.gestion.dto.ClientDto;
import com.gestion.gestion.entity.Client;
import com.gestion.gestion.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    /**
    liste de tous les cllients
    * */
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    /**
     liste d'un cllient
     * */
    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }
    /**
     enregistrer un cllient
     * */
    public Client save(ClientDto clientDto) {
        Client client = new Client();
        client.setNom(clientDto.getNom());
        client.setEmail(clientDto.getEmail());
        client.setTelephone(clientDto.getTelephone());
        return clientRepository.save(client);
    }
    /**
     * update un client
     * */
    public Client update(ClientDto clientDto) {
        Client client = findById(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setEmail(clientDto.getEmail());
        client.setTelephone(clientDto.getTelephone());
        return clientRepository.save(client);
 }


}
