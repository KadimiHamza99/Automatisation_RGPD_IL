package io.kadev.dto;

import io.kadev.models.DataUsage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Builder
@NoArgsConstructor
public class DataUsageApiResponse {
	private GdprData data;
	private DataUsage dataUsage;
}
