package org.etsmtl.mti777.dao;

import org.etsmtl.mti777.model.ItemCategory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ItemCategoryRepository extends BaseRepository<ItemCategory,Long> {

	@Modifying
	@Query("update ItemCategory itemCategory set itemCategory.name = :name"
			+ " where itemCategory.iditemCategory = :id")
	void update(@Param("name") String name, @Param("id") Long id);

	@Modifying
	@Query(value = "insert into itemCategory (name,rootCategory) values (:name,:idroot)",nativeQuery=true)
	void save(@Param("name") String name, @Param("idroot") Long idroot);		

}
