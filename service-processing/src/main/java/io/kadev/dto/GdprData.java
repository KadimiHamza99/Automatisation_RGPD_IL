package io.kadev.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class GdprData {
	private int dataID;
	private String source;
	private int dataConservation;
	private boolean isPersonal;
	private boolean isModifiable;
	private int dataTypeID;
	private String data_ID_ref;
	private int dataSubjectID;
	private Date creationDate;
	private Date lastModificationDate;
	private Date deletionDate;
	private String attributeName;
	private boolean isDeleted;
}
