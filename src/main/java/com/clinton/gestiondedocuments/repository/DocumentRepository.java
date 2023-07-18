package com.clinton.gestiondedocuments.repository;


import com.clinton.gestiondedocuments.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

    Optional<Document> findByTitre(String titre);

}
