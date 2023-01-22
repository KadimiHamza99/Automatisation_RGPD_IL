package io.kadev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class Provider extends Actor{
	private int providerID;
	private String prName;
	private String prAddress;
	private String prPostalCode;
	private String prCity;
	private String prPhone;
	private String prEmail;
	private String prCountry;
}
