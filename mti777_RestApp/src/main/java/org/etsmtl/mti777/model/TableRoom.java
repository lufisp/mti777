package org.etsmtl.mti777.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@javax.persistence.Table(name = "tableRoom")
public class TableRoom {

	@Id
	@GeneratedValue
	private Long idtable;

	private String name;
	
	private Boolean availableFlag;
	
	private int places;

	public Long getIdtable() {
		return idtable;
	}

	public void setIdtable(Long idtable) {
		this.idtable = idtable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getAvailableFlag() {
		return availableFlag;
	}

	public void setAvailableFlag(Boolean availableFlag) {
		this.availableFlag = availableFlag;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

	
	

}
