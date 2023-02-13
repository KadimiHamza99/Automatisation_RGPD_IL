package io.kadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kadev.models.Mesure;

public interface MesureRepository extends JpaRepository<Mesure, Integer>{

}
