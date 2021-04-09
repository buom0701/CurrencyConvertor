package com.cc.CurrencyConvertor.resources;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cc.CurrencyConvertor.model.Currency;


@RestController
@RequestMapping(value="/convert")
public class CurrencyConvertorController {

	
	@RequestMapping(value = "/currency")
	public double getcurrency(@RequestBody Currency currency) {
		
		String fromto = currency.getFromcurrency() + "_" + currency.getTocurrency();
		String apiKey = "ee71871813e0d5aa294f";
		String uri = "https://free.currconv.com/api/v7/convert?q="+ fromto +"&compact=ultra&apiKey="  + apiKey;
		
		RestTemplate rt = new RestTemplate();
		
		String R = rt.getForObject(uri, String.class).replaceAll("}", "");
		
		String [] A = R.split(":");
		
		return currency.finalamount(Double.valueOf(A[1])); 
	
	}	
		
		
	}
	

