package io.kadev;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.kadev.enumerations.ProcessingCategory;
import io.kadev.enumerations.ProcessingType;
import io.kadev.models.DataUsage;
import io.kadev.models.Mesure;
import io.kadev.models.Processing;
import io.kadev.models.Purpose;
import io.kadev.repositories.MesureRepository;
import io.kadev.repositories.PurposeRepository;
import io.kadev.services.DataUsageServiceInterface;
import io.kadev.services.ProcessingServiceInterface;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProcessingApplication.class, args);
	}
	
	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	ProcessingServiceInterface processingService;
	@Autowired
	DataUsageServiceInterface dataUsageService;
//	@Autowired
//	MesureRepository mesureRepo;
//	@Autowired
//	PurposeRepository purposeRepo;
	
	@Bean
	CommandLineRunner start() {
		return args->{
			List<DataUsage> dataUsages = new ArrayList<DataUsage>();		
			List<Purpose> purposes = new ArrayList<Purpose>();
			List<Mesure> mesures = new ArrayList<Mesure>();
			Processing processing = new Processing("Processing1",ProcessingType.NECESSARY,
					ProcessingCategory.CONSENT,new Date(),new Date(),dataUsages,purposes,mesures);
			DataUsage dataUsage1 = new DataUsage(true,true,true,true,true,processing,1);
			DataUsage dataUsage2 = new DataUsage(true,false,true,false,false,processing,2);
			dataUsages.add(dataUsage1);
			dataUsages.add(dataUsage2);
					
//			List<DataUsage> dataUsages1 = new ArrayList<DataUsage>();		
//			List<Purpose> purposes1 = new ArrayList<Purpose>();
//			List<Mesure> mesures1 = new ArrayList<Mesure>();
//			Processing processing1 = new Processing("Processing2",ProcessingType.DEFAULT,
//					ProcessingCategory.LEGITIMATE_INTEREST,new Date(),new Date(),dataUsages,purposes1,mesures1);
//			DataUsage dataUsage11 = new DataUsage(false,false,true,true,true,processing,1);
//			DataUsage dataUsage21 = new DataUsage(true,false,true,false,false,processing,2);
//			dataUsages1.add(dataUsage11);
//			dataUsages1.add(dataUsage21);
//			processingService.createProcessing(processing1);
//			dataUsageService.createDataUsage(dataUsage11);
//			dataUsageService.createDataUsage(dataUsage21);

			processingService.createProcessing(processing);
			dataUsageService.createDataUsage(dataUsage1);
			dataUsageService.createDataUsage(dataUsage2);
			
		};
	}

}
