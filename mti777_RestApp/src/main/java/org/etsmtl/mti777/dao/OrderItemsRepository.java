package org.etsmtl.mti777.dao;

import java.util.List;

import org.etsmtl.mti777.model.OrderItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrderItemsRepository extends BaseRepository<OrderItems,Long> {

	@Query("SELECT orderItems FROM OrderItems orderItems WHERE orderItems.orderClient.idOrder = :orderClientId")
	List<OrderItems> listItemsByOrder(@Param("orderClientId") Long orderClientId);
		

}
