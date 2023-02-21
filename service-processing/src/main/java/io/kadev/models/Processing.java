package io.kadev.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import io.kadev.enumerations.ProcessingCategory;
import io.kadev.enumerations.ProcessingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gdpr_Processing")
@Data @AllArgsConstructor @NoArgsConstructor
public class Processing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private ProcessingType type;
	
	private ProcessingCategory category;
	
	@Column(nullable = true,updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(nullable = true)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatingDate;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<DataUsage> dataUsages;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Purpose> purposes;
	
	public Processing(String name, ProcessingType type, ProcessingCategory category, Date creationDate,
			Date updatingDate, List<DataUsage> dataUsages, List<Purpose> purposes, List<Mesure> mesures) {
		super();
		this.name = name;
		this.type = type;
		this.category = category;
		this.creationDate = creationDate;
		this.updatingDate = updatingDate;
		this.dataUsages = dataUsages;
		this.purposes = purposes;
		this.mesures = mesures;
	}

	@ManyToMany
	@JoinTable(name = "gdpr_ProcessingMesure", joinColumns = @JoinColumn(name = "processingID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "mesureID", referencedColumnName = "mesureID"))
	private List<Mesure> mesures;
}
