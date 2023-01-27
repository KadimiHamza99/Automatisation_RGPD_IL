package io.kadev.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.kadev.enumerations.CategoryMesure;
import io.kadev.enumerations.TypeMesure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "gdpr_mesure")
public class Mesure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mesureID;
	private String description;
	private TypeMesure type;
	private CategoryMesure category;
}
