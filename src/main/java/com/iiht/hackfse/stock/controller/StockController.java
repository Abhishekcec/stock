package com.iiht.hackfse.stock.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.hackfse.stock.model.Stock;
import com.iiht.hackfse.stock.service.StockService;

@RestController
@RequestMapping("/api/v1.0/market/company")
public class StockController {
	
	@Autowired
	private StockService stockService;

	
	@PostMapping(value="/add/stock")
	public String saveCompany(@RequestBody Stock stock){
		System.out.println("stock");
		System.out.println(stock);
		stockService.saveStock(stock);
		return "saved successfully";
		
	}
	
	@GetMapping("/get/{companyCode}/{startDate}/{endDate}")
	public ResponseEntity<Double> getStock(@PathVariable String companyCode, @PathVariable @DateTimeFormat String startDate, @PathVariable @DateTimeFormat String endDate){
			LocalDateTime newStartDate = LocalDateTime.parse(startDate);
			LocalDateTime newEndDate = LocalDateTime.parse(endDate);
			List<Double> stockPrice = stockService.getCompanyStockPrice(newStartDate, newEndDate, companyCode);
			return new ResponseEntity(stockPrice, HttpStatus.OK);
	}
	
	
}
