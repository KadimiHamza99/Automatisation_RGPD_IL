package io.kadev.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.kadev.enumerations.PurposeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "gdpr_purpose")
public class Purpose {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purposeID;
	@Column(nullable = false)
	private String description;
	private PurposeType type;
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private Processing processing;
}
