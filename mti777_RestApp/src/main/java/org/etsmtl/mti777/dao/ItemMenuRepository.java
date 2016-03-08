package org.etsmtl.mti777.dao;

import java.util.List;

import org.etsmtl.mti777.model.ItemMenu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ItemMenuRepository extends BaseRepository<ItemMenu,Long> {

	@Query("SELECT itemMenu FROM ItemMenu itemMenu WHERE itemMenu.itemCategory.iditemCategory = :categoryId")
	List<ItemMenu> listByCategory(@Param("categoryId") Long categoryId);
		

}
