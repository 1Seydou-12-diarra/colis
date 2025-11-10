package com.gestion.gestion.repository;

import com.gestion.gestion.entity.Livraison;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivraisonRepository extends CrudRepository<Livraison, Long> {

    List<Livraison> findByClientId(Long clientId);
}
