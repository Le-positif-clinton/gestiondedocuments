package com.clinton.gestiondedocuments.repository;

import com.clinton.gestiondedocuments.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.stream.DoubleStream;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {


//    JPQL QUERY
    @Query(value = "select u from Utilisateur u where u.email = :email")
    Optional<Utilisateur> findUtilisateurByEmail(@Param("email") String email);
}
