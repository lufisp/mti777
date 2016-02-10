package org.etsmtl.mti777.dao;

import java.util.List;

import org.etsmtl.mti777.model.ItemMenu;
import org.etsmtl.mti777.model.ItemMenuDet;
import org.springframework.data.jpa.repository.Query;


public interface ItemMenuDetRepository extends BaseRepository<ItemMenuDet,Long> {

	@Query(value = "select * "
			+ "from mti777Bd.itemMenuDet "
			+ "where (iditemMenu, version, creationDate) in ("
			+ " select iditemMenu,version,max(creationDate) "
			+ " from mti777Bd.itemMenuDet "
			+ " group by iditemMenu, version"
			+ ")",nativeQuery = true)
	List<ItemMenuDet> listLastUpdated();
		

}
