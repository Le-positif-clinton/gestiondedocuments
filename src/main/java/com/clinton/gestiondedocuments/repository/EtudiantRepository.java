package com.clinton.gestiondedocuments.repository;

import com.clinton.gestiondedocuments.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    Optional<Etudiant> findByMatricule(String matricule);
    Optional<Etudiant> deleteByMatricule(String matricule);

}
