package io.kadev.services;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.kadev.models.Processing;
import io.kadev.repositories.ProcessingRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
@Transactional
@Service
public class ProcessingService implements ProcessingServiceInterface  {
	
	private ProcessingRepository repository;

	@Override
	public Processing createProcessing(Processing processing) {
		log.info("CreateProcessing start Process !");
		Processing res = repository.save(processing);
		log.info("CreateProcessing end Process !");
		return res;
	}

	@Override
	public Processing updateProcessing(Long id,Processing processing) {
		log.info("UpdateProcessing start Process !");
		Processing oldProcessing = repository.findById(id).get();
		oldProcessing.setCategory(processing.getCategory());
		oldProcessing.setCreationDate(processing.getCreationDate());
		oldProcessing.setDataUsages(processing.getDataUsages());
		oldProcessing.setMesures(processing.getMesures());
		oldProcessing.setName(processing.getName());
		oldProcessing.setPurposes(processing.getPurposes());
		oldProcessing.setType(processing.getType());
		oldProcessing.setUpdatingDate(new Date());
		repository.save(oldProcessing);
		log.info("UpdateProcessing end Process !");
		return oldProcessing;
	}

	@Override
	public boolean deleteProcessing(Long processingId) {
		log.info("DeleteProcessing start Process");
		repository.deleteById(processingId);
		log.info("DeleteProcessing end Process");
		return true;
	}

	@Override
	public Processing getProcessing(Long processingId) {
		return repository.findById(processingId).orElseThrow();
	}

	@Override
	public Collection<Processing> getProcessings() {
		return repository.findAll();
	}
	
	
	
}
