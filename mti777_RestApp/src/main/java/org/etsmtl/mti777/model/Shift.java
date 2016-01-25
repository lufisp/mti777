package org.etsmtl.mti777.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shift")
public class Shift {

	@Id
	@GeneratedValue
	private Long idshift;

	private String name;

	public Long getIdshift() {
		return idshift;
	}

	public void setIdshift(Long idshift) {
		this.idshift = idshift;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
