package com.iiht.hackfse.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.hackfse.stock.model.Stock;

@Repository
public interface StockRepository  extends JpaRepository<Stock, String>{

	List<Stock> findByCompanyCode(String companyCode);

}