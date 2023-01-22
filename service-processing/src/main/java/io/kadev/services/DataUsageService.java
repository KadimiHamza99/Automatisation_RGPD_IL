package io.kadev.services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.kadev.models.DataUsage;
import io.kadev.repositories.DataUsageRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
@Service
@Transactional
public class DataUsageService implements DataUsageServiceInterface{

	private DataUsageRepository repository;
	
	@Override
	public DataUsage createDataUsage(DataUsage dataUsage) {
		log.info("CreateDataUsage start Process !");
		DataUsage res = repository.save(dataUsage);
		log.info("CreateDataUsage end Process !");
		return res;
	}

	@Override
	public DataUsage updateDataUsage(DataUsage dataUsage) {
		log.info("UpdateDataUsage start Process !");
		DataUsage res = repository.save(dataUsage);
		log.info("UpdateDataUsage end Process !");
		return res;
	}

	@Override
	public boolean deleteDataUsage(Long dataUsageId) {
		log.info("DeleteDataUsage start Process");
		repository.deleteById(dataUsageId);
		log.info("DeleteDataUsage end Process");
		return true;
	}

	@Override
	public DataUsage getDataUsage(Long dataUsageId) {
		return repository.findById(dataUsageId).orElseThrow();
	}

	@Override
	public Collection<DataUsage> getDataUsages() {
		return repository.findAll();
	}

}
