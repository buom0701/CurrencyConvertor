package com.cc.CurrencyConvertor.resources;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cc.CurrencyConvertor.model.Root;
import com.cc.CurrencyConvertor.model.Amount;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/currency")
public class CurrencyConvertorController {

	
	@RequestMapping(value = "/{amount}/{fromcurrency}/{tocurrency}")
	public double getcurrency(@PathVariable int amount, 
							@PathVariable String fromcurrency, 
							@PathVariable String tocurrency) throws IOException {
		
		String fromto = fromcurrency + "_" + tocurrency;
		String apiKey = "ee71871813e0d5aa294f";
		String uri = "https://free.currconv.com/api/v7/convert?q="+ fromto +"&compact=y&apiKey="  + apiKey;
		
		RestTemplate rt = new RestTemplate();
		
		String R = rt.getForObject(uri, String.class);
		
// below commented code returns simple String in JSON format. No POJO used.
// need to update return type to String to make this work and comment out other code below this.
		
		//return R; 
		
		
// this code returns to currency ONLY when currencies are USD to PHP. This is because how the JSON response is designed within substrings.
// if you look at Root.java, I had to keep hard coded JSONproperty "USD_SAR".
// I have been trying find a way to parse JSON response to only store 'val' field OR somehow make JsonProperty annotation dynamic to take user input currencies.
// no luck so far.
// Also need t
		
		ObjectMapper om = new ObjectMapper();
		Root M = om.readValue(R, Root.class);
		return (Amount.getVal()*amount);
	
	}	
		
		
	}
	

