package ru.simanov.javalessons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import ru.simanov.javalessons.models.SocksForm;
import ru.simanov.javalessons.services.SocksService;

@Controller
@RequestMapping(value = "/api/socks", headers = "Content-Type=application/json")
public class SocksController {
	@Autowired
	private SocksService service;

	private Gson gson = new Gson();
	
	@PostMapping(value = "/income")
	public ResponseEntity<String> income(@RequestBody String json) {
		SocksForm socks;
		
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
		SocksForm socks;
		
		try {
			socks = fillSockByJson(json);
		} catch(Exception e) {
			return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body(e.toString());
		}
		return ResponseEntity.ok(service.outcome(socks));
	}
	
	private SocksForm fillSockByJson(String jsonString) throws Exception {
		SocksForm socks;
		socks = gson.fromJson(jsonString, SocksForm.class);
		socks.hundleValidate();
		return socks;
	}
}
