package com.mit.transcation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mit.transcation.model.Excel;

@Repository
public interface ExcelRepository extends JpaRepository<Excel,Long>{

	@Modifying
	@Query(value="INSERT INTO excelfile ( syskey,txnid, tin) "
			+ "VALUES ( :#{#entity.syskey},:#{#entity.txnId}, :#{#entity.tId});",nativeQuery=true)
	void insertExcel(@Param("entity") Excel entity);
}
