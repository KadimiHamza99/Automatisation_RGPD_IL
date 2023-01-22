package io.kadev.services;

import java.util.Collection;

import io.kadev.models.DataUsage;

public interface DataUsageServiceInterface {
	DataUsage createDataUsage(DataUsage dataUsage);
	DataUsage updateDataUsage(DataUsage dataUsage);
	boolean deleteDataUsage(Long dataUsageId);
	DataUsage getDataUsage(Long dataUsageId);
	Collection<DataUsage> getDataUsages();
}
