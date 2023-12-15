package com.mit.transcation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mit.transcation.model.Excel;

@Repository
public interface ExcelRepository extends JpaRepository<Excel,Long>{

	@Modifying
	@Query(value="INSERT INTO excelfile ( syskey,txnid, tin,todaydate,filename ) "
			+ "VALUES ( :#{#entity.syskey},:#{#entity.txnId}, :#{#entity.tId},:#{#entity.todaydate},:#{#entity.filename});",nativeQuery=true)
	void insertExcel(@Param("entity") Excel entity);

	@Modifying
	@Query("DELETE FROM Excel ec WHERE ec.todaydate = CURRENT_DATE AND ec.filename = :filename")
	int deleteExcelByDate(@Param("filename") String filename);


	

}
