package com.clinton.gestiondedocuments.repository;

import com.clinton.gestiondedocuments.model.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichierRepository extends JpaRepository <Fichier, String>{

}
