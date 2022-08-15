package com.iiht.hackfse.stock.service.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.hackfse.stock.model.Stock;
import com.iiht.hackfse.stock.repository.StockRepository;
import com.iiht.hackfse.stock.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository stockRepository;

	@Override
	public Stock saveStock(Stock stock) {
		// TODO Auto-generated method stub
		System.out.println(stock.toString());
		return stockRepository.save(stock);
	}

	@Override
	public List<Double> getCompanyStockPrice(LocalDateTime startDate, LocalDateTime endDate, String companyCode) {
		List<Stock> stocks = stockRepository.findByCompanyCode(companyCode);
		List<Double> companyStockPrice = new ArrayList<>();
		for(Stock stock : stocks) {
			if(stock.getDate().isAfter(startDate) && stock.getDate().isBefore(endDate)) {
				companyStockPrice.add(stock.getPrice());
			}
		}
		return companyStockPrice;
	}

}
