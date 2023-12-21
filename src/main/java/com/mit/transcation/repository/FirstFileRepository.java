package com.mit.transcation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mit.transcation.dto.CompareDTO;
import com.mit.transcation.model.FirstFile;

@Repository
public interface FirstFileRepository extends JpaRepository<FirstFile, Long> {

    @Modifying
    @Query(value = "INSERT INTO firstfile ( syskey,accnumber, panid,todaydate,filename) "
            + "VALUES ( :#{#entity.syskey},:#{#entity.accNumber}, :#{#entity.panId},:#{#entity.todaydate},:#{#entity.filename});", nativeQuery = true)
    void insertFirstFile(@Param("entity") FirstFile entity);

    @Query("SELECT new com.mit.transcation.dto.CompareDTO(ff.syskey, ff.panId, ff.accNumber, e.syskey, e.txnId, e.tId) FROM FirstFile ff FULL OUTER JOIN Excel e ON ff.accNumber = e.txnId")
    List<CompareDTO> getTxnIdAndAccNumberJoin();

    @Modifying
    @Query("DELETE FROM FirstFile ff WHERE ff.todaydate = CURRENT_DATE AND ff.filename = :filename")
    void deleteFirstFileByDate(@Param("filename") String filename);

    @Query("SELECT new com.mit.transcation.dto.CompareDTO(ff.syskey, ff.panId, ff.accNumber, e.syskey, e.txnId, e.tId) FROM FirstFile ff FULL OUTER JOIN Excel e ON ff.accNumber = e.txnId WHERE "
            + " CAST(ff.todaydate AS date) = CAST(GETDATE() AS date)")
    Page<CompareDTO> getTxnIdAndAccNumberJoin(Pageable pageable);

}
