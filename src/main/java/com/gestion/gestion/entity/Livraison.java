package com.gestion.gestion.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
    public class Livraison {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String adresseLivraison;

        @Enumerated(EnumType.STRING)
        private StatutLivraison statut;

        @ManyToOne
        @JsonIgnoreProperties("livraisons") // Ignore la liste livraisons du client
        @JoinColumn(name = "client_id")
        private Client client;

        @ManyToOne
        @JsonIgnoreProperties("livraisons") // Ignore la liste livraisons du client
        @JoinColumn(name = "chauffeur_id")
        private Chauffeur chauffeur;

        @OneToMany(mappedBy = "livraison", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("livraisons") // Ignore la liste livraisons du client
        @JsonIgnore
        private List<Colis> colis;
    }

