package org.etsmtl.mti777.dao;

import java.util.List;

import org.etsmtl.mti777.model.OrderClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrderClientRepository extends BaseRepository<OrderClient,Long> {

	@Query("SELECT orderCli FROM OrderClient orderCli WHERE orderCli.tableRoom.idtable = :tableId")
	List<OrderClient> listOrderByTable(@Param("tableId") Long tableId);

	@Query(   " SELECT SUM(orderItems.quantity * orderItems.itemMenuDet.prix)"
			+ " FROM OrderItems orderItems WHERE orderItems.orderClient.idOrder = :id")
	String getTotal(@Param("id") Long id);
		

}
