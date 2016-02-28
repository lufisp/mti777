package org.etsmtl.mti777.dao;

import org.etsmtl.mti777.model.Shift;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


//public interface PaymentTypeRepository extends CrudRepository<PaymentType,Long> {
public interface ShiftRepository extends BaseRepository<Shift,Long> {

	@Modifying
	@Query("update Shift shift set shift.active = true where shift.id = :shiftId")
	void activate(@Param("shiftId") Long shiftId);

	@Modifying
	@Query("update Shift shift set shift.active = false")
	void desactivateAll();
	
	@Query("select shift from Shift shift where shift.active = true")
	Shift getActive();
		

}
