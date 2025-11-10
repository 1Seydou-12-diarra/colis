package com.gestion.gestion.repository;

import com.gestion.gestion.entity.Colis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColisRepository extends JpaRepository<Colis, Long> {
    @Override
    Optional<Colis> findById(Long id);
}
