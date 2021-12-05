package ru.simanov.javalessons.controllers;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import ru.simanov.javalessons.DTO.SocksDTO;


@Controller
@RequestMapping("/api/socks")
@Validated
public class SocksController {
	private Gson gson = new Gson();
	
	@GetMapping()
	public ResponseEntity<String> getSumSocks(@RequestParam String color
							                 ,@RequestParam @Pattern(regexp = "moreThen|lessThen|equal") String operation
							                 ,@RequestParam @Min(0) @Max(value = 100, message = "cotton part has to be less than or equal to 100") int cottonPart
							              ) {
		System.out.println(color);
		System.out.println(operation);
		System.out.println(cottonPart);
		return ResponseEntity.ok(String.valueOf(5454));
	}
	
	@PostMapping(value = "/income",
			    headers = "Content-Type=application/json")
	public ResponseEntity<String> income(@RequestBody String json) {
		
		SocksDTO socks;
		
		try {
			socks = fillSocksByJson(json);
		} catch(Exception e) {
			return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body(e.toString());
		}
		
		System.out.println("color = " + socks.getColor());
		System.out.println("cottonpart = " + socks.getCottonPart());
		System.out.println("quantity = " + socks.getQuantity());
		return ResponseEntity.ok(json);
	}
	
	@PostMapping(value = "/outcome",
		    	headers = "Content-Type=application/json")
	public ResponseEntity<String> outcome(@RequestBody String json) {
		SocksDTO socks;
		
		try {
			socks = fillSocksByJson(json);
		} catch(Exception e) {
			return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body(e.toString());
		}
		
		System.out.println("color = " + socks.getColor());
		System.out.println("cottonpart = " + socks.getCottonPart());
		System.out.println("quantity = " + socks.getQuantity());
		return ResponseEntity.ok(json);
	}
	
	private SocksDTO fillSocksByJson(String jsonString) throws Exception {
		SocksDTO socks;
		socks = gson.fromJson(jsonString, SocksDTO.class);
		socks.hundleValidate();
		return socks;
	}
}
