package io.kadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.kadev.models.Processing;

@Repository
public interface ProcessingRepository extends JpaRepository<Processing, Long>{
	
}
