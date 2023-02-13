package io.kadev.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.kadev.dto.DataSubjectCategory;
import io.kadev.dto.GdprData;
import io.kadev.dto.ProcessingApiResponse;
import io.kadev.models.Processing;
import io.kadev.services.ProcessingServiceInterface;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/processing")
@AllArgsConstructor
public class ProcessingController {
	
	@Autowired
	ProcessingServiceInterface service;
	@Autowired
	RestTemplate template;
	
	
	@PostMapping("/create")
	public Processing newProcessing(Processing processing) {
		return service.createProcessing(processing);
	}
	
	@PutMapping("/update")
	public Processing modifyProcessing(Processing processing) {
		return service.updateProcessing(processing);
	}
	
	@GetMapping("/{id}")
	public ProcessingApiResponse getProcessing(@PathVariable Long id) {
		Processing processing = service.getProcessing(id);
		List<GdprData> datas = new ArrayList<GdprData>();
		List<DataSubjectCategory> dscs = new ArrayList<DataSubjectCategory>(); 
		processing.getDataUsages().stream().forEach(dataUsage->{
			GdprData[] data = template.getForObject("http://localhost:3000/Data?dataID="+dataUsage.getDataId(), GdprData[].class);
			datas.add(data[0]);
			DataSubjectCategory[] dsc = template.getForObject("http://localhost:3000/DataSubjectCategory?dsCategoryID="+data[0].getDataSubjectCategoryID(), DataSubjectCategory[].class);
			dscs.add(dsc[0]);
		});
		ProcessingApiResponse response = new ProcessingApiResponse(processing,datas,dscs);
		return response;
	}
	
//	@GetMapping("/dsc/{dscID}")
//	public Collection<ProcessingApiResponse> getProcessings(@PathVariable int dscID){
//		Collection<Processing> processings = service.getProcessings();
//		List<ProcessingApiResponse> responses = new ArrayList<ProcessingApiResponse>();
//		processings.stream().forEach(processing -> {
//			List<GdprData> datas = new ArrayList<GdprData>();
//			List<DataSubjectCategory> dscs = new ArrayList<DataSubjectCategory>(); 
//			processing.getDataUsages().stream().forEach(dataUsage->{
//				GdprData[] data = template.getForObject("http://localhost:3000/Data?dataID="+dataUsage.getDataId(), GdprData[].class);
//				datas.add(data[0]);
//				DataSubjectCategory dsc = template.getForObject("http://localhost:3000/DataSubjectCategory?dsCategoryID="+dscID, DataSubjectCategory.class);
//				dscs.add(dsc);
//			});
//			ProcessingApiResponse response = new ProcessingApiResponse(processing,datas,dscs);
//			responses.add(response);
//		});
//		return responses;
//	}
}
