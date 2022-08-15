package com.iiht.hackfse.stock.service;

import java.time.LocalDateTime;
import java.util.List;

import com.iiht.hackfse.stock.model.Stock;

public interface StockService {

	Stock saveStock(Stock stock);

	List<Double> getCompanyStockPrice(LocalDateTime newStartDate, LocalDateTime newEndDate, String companyCode);

}
