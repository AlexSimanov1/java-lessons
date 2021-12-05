package ru.simanov.javalessons.controllers;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
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

import ru.simanov.javalessons.models.Socks;
import ru.simanov.javalessons.services.SocksService;


@Controller
@RequestMapping(value = "/api/socks", headers = "Content-Type=application/json")
@Validated
public class SocksController {
	@Autowired
	private SocksService service;
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
	
	@PostMapping(value = "/income")
	public ResponseEntity<String> income(@RequestBody String json) {
		Socks socks;
		
		try {
			socks = fillSockByJson(json);
		} catch(Exception e) {
			return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body(e.toString());
		}
		
		return ResponseEntity.ok(service.income(socks));
	}
	
	//@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/outcome")
	public ResponseEntity<String> outcome(@RequestBody String json) {
		Socks socks;
		
		try {
			socks = fillSockByJson(json);
		} catch(Exception e) {
			return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body(e.toString());
		}

		return ResponseEntity.ok(service.outcome(socks));
	}
	
	private Socks fillSockByJson(String jsonString) throws Exception {
		Socks socks;
		socks = gson.fromJson(jsonString, Socks.class);
		socks.hundleValidate();
		return socks;
	}
}
