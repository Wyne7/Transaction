package com.mit.transcation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mit.transcation.dto.CompareDTO;
import com.mit.transcation.model.FirstFile;

@Repository
public interface  FirstFileRepository  extends JpaRepository<FirstFile, Long>{
	
	@Modifying
	@Query(value="INSERT INTO firstfile ( syskey,accnumber, panid) "
			+ "VALUES ( :#{#entity.syskey},:#{#entity.accNumber}, :#{#entity.panId});",nativeQuery=true)
	void insertFirstFile(@Param("entity") FirstFile entity);

	@Query("SELECT new com.mit.transcation.dto.CompareDTO(e.txnId, ff.accNumber) FROM FirstFile ff LEFT JOIN Excel e ON ff.panId = e.txnId")
	List<CompareDTO> getTxnIdAndAccNumberJoin();

}
