package com.clinton.gestiondedocuments.repository;

import com.clinton.gestiondedocuments.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Integer> {

//    Action findByNumero(int numero)

}
