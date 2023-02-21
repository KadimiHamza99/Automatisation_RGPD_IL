package io.kadev.services;

import java.util.Collection;

import io.kadev.models.Processing;

public interface ProcessingServiceInterface {
	Processing createProcessing(Processing processing);
	Processing updateProcessing(Long processingID,Processing processing);
	boolean deleteProcessing(Long processingId);
	Processing getProcessing(Long processingId);
	Collection<Processing> getProcessings();
}
