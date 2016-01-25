package org.etsmtl.mti777.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemCategory")
public class ItemCategory {

	@Id
	@GeneratedValue
	private Long iditemCategory;

	private String name;
	
	@ManyToOne
	private ItemCategory rootCategory;
	
	/*	
    @OneToMany(mappedBy="parent")
    private Collection<A> children;
	*/

	public Long getIditemCategory() {
		return iditemCategory;
	}

	public void setIditemCategory(Long iditemCategory) {
		this.iditemCategory = iditemCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemCategory getRootCategory() {
		return rootCategory;
	}

	public void setRootCategory(ItemCategory rootCategory) {
		this.rootCategory = rootCategory;
	}
	
	
	

	
	

}
