package io.kadev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Tutor extends Actor{
	private int tutorID;
	private String tutorName;
	private String country;
}
