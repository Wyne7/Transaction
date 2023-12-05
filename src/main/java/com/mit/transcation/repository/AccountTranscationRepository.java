package com.mit.transcation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mit.transcation.dto.TransactionRequestDTO;
import com.mit.transcation.model.AccountTransaction;

@Repository
public interface AccountTranscationRepository extends JpaRepository<AccountTransaction, Long> {

	@Query(value = "SELECT COALESCE(currentbalance, 0.0) AS balance FROM accountbalances WHERE accnumber = :accNumber FOR UPDATE", nativeQuery = true)
	Double getBalanceByAccNumber(@Param("accNumber") String accNumber);

    @Modifying
    @Query(value = "UPDATE accountbalances SET currentbalance = currentbalance + :amount, lastupdate = now(), lasttransdate = now() WHERE accnumber = :fromAccNumber", nativeQuery = true)
    void updateFromAccNumber(@Param("fromAccNumber") String accNumber,@Param("amount") double amount);

    @Modifying
    @Query(value = "UPDATE accountbalances SET currentbalance = currentbalance + :amount, lastupdate = now(), lasttransdate = now() "
            + "WHERE accnumber = :toAccNumber", nativeQuery = true)
    void updateToAccNumber( @Param("toAccNumber") String accNumber,@Param("amount") double amount);


	
	@Modifying
	@Query(value = "INSERT INTO accounttransactions (syskey, transref, branchcode, tellerid, supervisorid, "
			+ "transtime, transdate, effectivedate, dr_accnumber, cr_accnumber,"
			+ " dr_amount, cr_amount, dr_transtype, cr_transtype, dr_description,"
			+ " cr_description,  accref, subref, updatedAt,createdAt)  " +
	        "VALUES (:#{#entity.syskey},:#{#entity.syskey}, :#{#entity.branchcode}, 'Off001', '010',"
	        + "  now(),now(), now(),  :#{#entity.fromaccnumber}, :#{#entity.toaccnumber},"
	        + " :#{#entity.amount}, :#{#entity.amount}, 705, 205, 'Transfer Debit', "
	        + "'Transfer Credit', '', '', now(), now())", nativeQuery = true)
	void insertTransaction(@Param("entity") TransactionRequestDTO entity);
}
