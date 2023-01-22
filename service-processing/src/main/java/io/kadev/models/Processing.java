package io.kadev.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import io.kadev.enumerations.ProcessingCategory;
import io.kadev.enumerations.ProcessingType;
import io.kadev.enumerations.PurposeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GDPR_PROCESSING")
@Data @AllArgsConstructor @NoArgsConstructor
public class Processing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private ProcessingType type;
	
	private ProcessingCategory category;
	
	@Column(nullable = false,updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(nullable = false)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatingDate;
	
	private String purposeDescription;
	
	private PurposeType purposeType;
	
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> actorsId;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<DataUsage> dataUsages;
}
