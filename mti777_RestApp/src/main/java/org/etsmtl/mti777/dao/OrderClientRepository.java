package org.etsmtl.mti777.dao;

import java.util.List;

import org.etsmtl.mti777.model.OrderClient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrderClientRepository extends BaseRepository<OrderClient,Long> {

	@Query("SELECT orderCli FROM OrderClient orderCli "
			+ "WHERE orderCli.tableRoom.idtable = :tableId and "
			+ "orderCli.shift.idshift = :shiftId and "
			+ "orderCli.openFlag = true")
	List<OrderClient> listOrderByTable(@Param("tableId") Long tableId, @Param("shiftId") Long shiftId);

	@Query(   " SELECT SUM(orderItems.quantity * orderItems.itemMenuDet.prix)"
			+ " FROM OrderItems orderItems WHERE orderItems.orderClient.idOrder = :id")
	String getTotal(@Param("id") Long id);

	@Modifying
	@Query(value =   " update orderClient set openFlag = 0 where idorder = :idOrder",nativeQuery = true)
	void closeOrder(@Param("idOrder") String idOrder);
		

}
