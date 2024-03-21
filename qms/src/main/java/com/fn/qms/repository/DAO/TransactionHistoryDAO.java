package com.fn.qms.repository.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fn.qms.models.TransactionHistory;
import com.fn.qms.repository.TransactionHisRepository;

@Service
public class TransactionHistoryDAO {

	@Autowired
	TransactionHisRepository transactionHisRepository;

	/**
	 * lay thong tin mau bien ban theo ma
	 * 
	 * @param examinationCode
	 * @param type
	 * @return
	 */
	public void save(TransactionHistory transaction) {
		transactionHisRepository.save(transaction);
	}

}
