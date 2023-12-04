package com.mit.transcation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mit.transcation.dto.TransactionRequestDTO;
import com.mit.transcation.model.AccountTransaction;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface AccountTranscationRepository extends JpaRepository<AccountTransaction, Long> {

	@Query(value = "SELECT COALESCE(currentbalance, 0.0) AS balance FROM account_balance"
            + " WITH (ROWLOCK) WHERE accnumber = :accNumber", nativeQuery = true)
    double getBalanceByAccNumber(@Param("accNumber") String accNumber);

    @Modifying
    @Query(value = "UPDATE account_balance SET currentbalance = currentbalance - :amount, lastupdate = GETDATE(), lasttransdate = GETDATE() "
            + "WHERE accnumber = :fromAccNumber", nativeQuery = true)
    void updateFromAccNumber(@Param("fromAccNumber") String accNumber,@Param("amount") double amount);

    @Modifying
    @Query(value = "UPDATE account_balance SET currentbalance = currentbalance + :amount, lastupdate = GETDATE(), lasttransdate = GETDATE() "
            + "WHERE accnumber = :toAccNumber", nativeQuery = true)
    void updateToAccNumber( @Param("toAccNumber") String accNumber,@Param("amount") double amount);

//	@Modifying
//	@Query(value = "INSERT INTO account_transaction (syskey, branchcode, tellerid, supervisorid, transtime, transdate, effectivedate, dr_accnumber, cr_accnumber, dr_amount, cr_amount, dr_transtype, cr_transtype, dr_description, cr_description, createdate, updatedate, accref, subref) \" +\r\n"
//			+ "\"VALUES (:#{#entity.syskey},:#{#entity.branchcode}, 'Off001', '010',GETDATE(), GETDATE()::date, GETDATE(), :#{#entity.fromaccnumber},  :#{#entity.toaccnumber}, :#{#entity.amount}, :#{#entity.amount}, 705, 205, 'Transfer Debit', 'Transfer Credit', GETDATE(), GETDATE(), '', '')", nativeQuery = true)
//	void insertTransaction(@Param("entity") TransactionRequestDTO entity);
	
	@Modifying
	@Query(value = "INSERT INTO account_transaction (syskey,transref, branchcode, tellerid, supervisorid, transtime, transdate, effectivedate, dr_accnumber, cr_accnumber, dr_amount, cr_amount, dr_transtype, cr_transtype, dr_description, cr_description, createdate, updatedate, accref, subref) " +
	        "VALUES (:#{#entity.syskey},:#{#entity.syskey}, :#{#entity.branchcode}, 'Off001', '010', GETDATE(), GETDATE(), GETDATE(), :#{#entity.fromaccnumber}, :#{#entity.toaccnumber}, :#{#entity.amount}, :#{#entity.amount}, 705, 205, 'Transfer Debit', 'Transfer Credit', GETDATE(), GETDATE(), '', '')", nativeQuery = true)
	void insertTransaction(@Param("entity") TransactionRequestDTO entity);
}
