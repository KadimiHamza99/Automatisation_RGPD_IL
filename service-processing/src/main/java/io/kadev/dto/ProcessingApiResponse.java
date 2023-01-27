package io.kadev.dto;

import java.util.List;

import io.kadev.models.Processing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor @Builder 
public class ProcessingApiResponse {
	private Processing processing;
	private List<GdprData> datas;
	private List<DataSubjectCategory> dsc;
}
