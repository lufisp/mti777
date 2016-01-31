package org.etsmtl.mti777.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "itemMenuDet")
public class ItemMenuDet {

	@Id
	@GeneratedValue
	private Long iditemMenuDet;

	@ManyToOne
	@JoinColumn(name="idItemMenu")
	private ItemMenu itemMenu;
	
	private String version;
	
	@Column(precision=5, scale=2)
	private BigDecimal prix;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date creationDate;

	public Long getIditemMenuDet() {
		return iditemMenuDet;
	}

	public void setIditemMenuDet(Long iditemMenuDet) {
		this.iditemMenuDet = iditemMenuDet;
	}

	public ItemMenu getItemMenu() {
		return itemMenu;
	}

	public void setItemMenu(ItemMenu itemMenu) {
		this.itemMenu = itemMenu;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
	
	

}
