package com.clinton.gestiondedocuments.repository;

import com.clinton.gestiondedocuments.model.Administration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrationRepository extends JpaRepository<Administration, Integer> {
}
