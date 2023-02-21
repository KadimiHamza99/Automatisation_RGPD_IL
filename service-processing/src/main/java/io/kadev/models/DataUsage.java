package io.kadev.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gdpr_Datausage")
@Data @NoArgsConstructor @AllArgsConstructor
public class DataUsage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean personalStatus;
	
	private boolean c;
	
	private boolean r;
	
	private boolean u;
	
	private boolean d;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Processing processing;
	
	private int dataId;

	public DataUsage(boolean personalStatus, boolean c, boolean r, boolean u, boolean d, Processing processing,
			int dataId) {
		super();
		this.personalStatus = personalStatus;
		this.c = c;
		this.r = r;
		this.u = u;
		this.d = d;
		this.processing = processing;
		this.dataId = dataId;
	}
}
