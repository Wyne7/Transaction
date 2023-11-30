package com.mit.transcation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mit.transcation.model.AccountTransactionEntity;

import jakarta.transaction.Transactional;

@Repository
public interface AccountTranscationRepository extends JpaRepository<AccountTransactionEntity, Integer> {
    @Transactional
    @Modifying
@Query(value = "INSERT INTO account_transaction " +
        "(acc_number, acc_ref, amount, branch_code, cheque_no, contra_date, currency_code, currency_rate, " +
        "description, effective_date, prev_balance, prev_up_date, remark, serial_no, status, sub_ref, " +
        "supervisor_id, system_code, teller_id, trans_date, trans_no, trans_ref, trans_time, trans_type, work_station) " +
        "VALUES (:#{#entity.accNumber}, :#{#entity.accRef}, :#{#entity.amount}, :#{#entity.branchCode}, " +
        ":#{#entity.chequeNo}, :#{#entity.contraDate}, :#{#entity.currencyCode}, :#{#entity.currencyRate}, " +
        ":#{#entity.description}, :#{#entity.effectiveDate}, :#{#entity.prevBalance}, :#{#entity.prevUpDate}, " +
        ":#{#entity.remark}, :#{#entity.serialNo}, :#{#entity.status}, :#{#entity.subRef}, :#{#entity.supervisorId}, " +
        ":#{#entity.systemCode}, :#{#entity.tellerId}, :#{#entity.transDate}, :#{#entity.transNo}, :#{#entity.transRef}, " +
        ":#{#entity.transTime}, :#{#entity.transType}, :#{#entity.workStation})", nativeQuery = true)
void saveTransaction(@Param("entity") AccountTransactionEntity entity);


}
