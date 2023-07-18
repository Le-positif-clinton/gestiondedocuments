package com.clinton.gestiondedocuments.repository;

import com.clinton.gestiondedocuments.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
}
