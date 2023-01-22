package io.kadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.kadev.models.DataUsage;

@Repository
public interface DataUsageRepository extends JpaRepository<DataUsage, Long>{

}
