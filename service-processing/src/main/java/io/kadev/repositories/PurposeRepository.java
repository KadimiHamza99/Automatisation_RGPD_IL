package io.kadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kadev.models.Purpose;

public interface PurposeRepository extends JpaRepository<Purpose, Integer>{

}
