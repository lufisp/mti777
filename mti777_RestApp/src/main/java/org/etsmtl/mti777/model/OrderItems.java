package org.etsmtl.mti777.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderItems")
public class OrderItems {

	@Id
	@GeneratedValue
	private Long idorderItems;

	@ManyToOne
	@JoinColumn(name = "idItemMenuDet")
	private ItemMenuDet itemMenuDet;

	@ManyToOne
	@JoinColumn(name = "idOrder")
	private OrderClient orderClient;
	
	private int quantity;
	
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getIdorderItems() {
		return idorderItems;
	}

	public void setIdorderItems(Long idorderItems) {
		this.idorderItems = idorderItems;
	}

	public ItemMenuDet getItemMenuDet() {
		return itemMenuDet;
	}

	public void setItemMenuDet(ItemMenuDet itemMenuDet) {
		this.itemMenuDet = itemMenuDet;
	}

	public OrderClient getOrderClient() {
		return orderClient;
	}

	public void setOrderClient(OrderClient orderClient) {
		this.orderClient = orderClient;
	}

	
}
