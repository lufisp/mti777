package org.etsmtl.mti777.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemMenu")
public class ItemMenu {

	@Id
	@GeneratedValue
	private Long iditemMenu;

	private String name;
	
	@ManyToOne
	private ItemCategory itemCategory;

	public Long getIditemMenu() {
		return iditemMenu;
	}

	public void setIditemMenu(Long iditemMenu) {
		this.iditemMenu = iditemMenu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	

}
