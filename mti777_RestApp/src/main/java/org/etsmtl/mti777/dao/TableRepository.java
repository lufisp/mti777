package org.etsmtl.mti777.dao;

import org.etsmtl.mti777.model.TableRoom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


//public interface PaymentTypeRepository extends CrudRepository<PaymentType,Long> {
public interface TableRepository extends BaseRepository<TableRoom,Long> {

	@Query(   " SELECT SUM(orderItems.quantity * orderItems.itemMenuDet.prix)"
			+ " FROM OrderItems orderItems WHERE orderItems.orderClient.tableRoom.idtable = :tableId "
			+ "and orderItems.orderClient.shift.idshift = :shiftId")
	String getTotal(@Param("tableId") Long tableId, @Param("shiftId") Long shiftId);
		

}
