package io.kadev.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.kadev.dto.DataSubjectCategory;
import io.kadev.dto.GdprData;
import io.kadev.dto.ProcessingApiResponse;
import io.kadev.models.Processing;
import io.kadev.services.ProcessingServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/processing")
@AllArgsConstructor
@Slf4j
public class ProcessingController {
	
	@Autowired
	ProcessingServiceInterface service;
	@Autowired
	RestTemplate template;
	
	
	@PostMapping("/create")
	public Processing newProcessing(Processing processing) {
		return service.createProcessing(processing);
	}
	
	@PutMapping("/update/{processingId}")
	public Processing modifyProcessing(@PathVariable Long processingId, @RequestBody Processing processing) {
		return service.updateProcessing(processingId,processing);
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
	
	@GetMapping("/dsc/{dscID}")
	public Collection<ProcessingApiResponse> getProcessingsByDscID(@PathVariable int dscID){
		List<ProcessingApiResponse> result = new ArrayList<ProcessingApiResponse>();
		service.getProcessings().stream().forEach(processing->{
			List<GdprData> datas = new ArrayList<GdprData>();
			List<DataSubjectCategory> dscs = new ArrayList<DataSubjectCategory>();
			processing.getDataUsages().stream().forEach(dataUsage->{
				GdprData[] data = template.getForObject("http://localhost:3000/Data?dataID="+dataUsage.getDataId()
						,GdprData[].class);
				if(data[0].getDataSubjectCategoryID()==dscID) {
					DataSubjectCategory[] dsc = template.getForObject("http://localhost:3000/DataSubjectCategory?dsCategoryID="+data[0].getDataSubjectCategoryID(), 
							DataSubjectCategory[].class);
					datas.add(data[0]);
					dscs.add(dsc[0]);
				}
			});
			result.add(new ProcessingApiResponse(processing,datas,dscs));
		});
		return result;
	}
	
}
