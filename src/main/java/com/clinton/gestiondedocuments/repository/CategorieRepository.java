package com.clinton.gestiondedocuments.repository;

import com.clinton.gestiondedocuments.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

    Optional<Categorie> findCategorieByCode(String code);

}
