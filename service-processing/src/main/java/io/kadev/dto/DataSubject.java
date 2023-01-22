package io.kadev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSubject extends Actor{
	private int dataSubjectID;
	private String data_subject_id_ref;
	private int tutorID;
	private int dataSubjectCategoryID;
}
