package com.mit.transcation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mit.transcation.model.FirstFile;

@Repository
public interface  FirstFileRepository  extends JpaRepository<FirstFile, Long>{
	
	@Modifying
	@Query(value="INSERT INTO firstfile ( syskey,accnumber, panid) "
			+ "VALUES ( :#{#entity.syskey},:#{#entity.accNumber}, :#{#entity.panId});",nativeQuery=true)
	void InsertFirstFile(@Param("entity") FirstFile entity);

}
