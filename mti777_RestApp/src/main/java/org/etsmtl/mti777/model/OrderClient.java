package org.etsmtl.mti777.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orderClient")
public class OrderClient {

	@Id
	@GeneratedValue
	private Long idOrder;

	@ManyToOne
	@JoinColumn(name = "tableId")
	private TableRoom tableRoom;

	@ManyToOne
	@JoinColumn(name = "shiftId")
	private Shift shift;

	private boolean openFlag;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date creationDate;

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public TableRoom getTableRoom() {
		return tableRoom;
	}

	public void setTableRoom(TableRoom tableRoom) {
		this.tableRoom = tableRoom;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public boolean isOpenFlag() {
		return openFlag;
	}

	public void setOpenFlag(boolean openFlag) {
		this.openFlag = openFlag;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
