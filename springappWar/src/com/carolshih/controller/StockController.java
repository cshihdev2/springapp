package com.carolshih.controller;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carolshih.core.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	private final StockService stockService; 
	
	@Autowired
	public StockController(StockService stockService) {
	        this.stockService = stockService;
	}
	
	@RequestMapping()
	public ModelAndView showHendler(){
		
		ModelAndView mav = new ModelAndView("stockDisplay");
		TreeMap<String, String> selectableFields = new TreeMap(this.stockService.getAvailableFields());
		if(selectableFields!=null){
			mav.addObject("fieldSelection", selectableFields);
		}

		return mav;
	}
	
	@RequestMapping(value = "/getSymbol/{symbol}", method = RequestMethod.GET)
	public ModelAndView getSymbolHendler(@PathVariable("symbol") String symbol, @RequestParam(value="fields") String fields){
		ModelAndView mav = new ModelAndView("stockDetails");

		TreeMap<String, String> result = (TreeMap) this.stockService.getStock(symbol, fields);
		mav.addObject("symbolDetail", result);
		return mav;
	}
}
