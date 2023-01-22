package io.kadev.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.kadev.dto.DataUsageApiResponse;
import io.kadev.dto.GdprData;
import io.kadev.models.DataUsage;
import io.kadev.services.DataUsageServiceInterface;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("processing/data-usage")
@AllArgsConstructor
public class DataUsageController {
	@Autowired
	RestTemplate template;
	@Autowired
	DataUsageServiceInterface service;
	
	@PostMapping("/create")
	public DataUsage newDataUsage(DataUsage dataUsage) {
		return service.createDataUsage(dataUsage);
	}
	
	@PutMapping("/update")
	public DataUsage modifyDataUsage(DataUsage dataUsage) {
		return service.updateDataUsage(dataUsage);
	}
	
	@GetMapping("/{id}")
	public DataUsageApiResponse getDataUsage(@PathVariable Long id) {
		DataUsage dataUsage = service.getDataUsage(id);
		GdprData data = template.getForObject("http:localhost:8080/express"+dataUsage.getDataId(), 
				GdprData.class);
		return new DataUsageApiResponse(data, dataUsage);
	}
	
	@GetMapping("")
	public List<DataUsageApiResponse> getDataUsages(){
		List<DataUsageApiResponse> response = new ArrayList<DataUsageApiResponse>() ;
		service.getDataUsages().stream().forEach(dataUsage->{
			GdprData data = template.getForObject("http:localhost:8080/express"+dataUsage.getDataId(), 
					GdprData.class);
			response.add(new DataUsageApiResponse(data,dataUsage));
		});
		return response;
	}
	
}
