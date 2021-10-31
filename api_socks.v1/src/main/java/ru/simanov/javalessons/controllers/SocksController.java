package ru.simanov.javalessons.controllers;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.simanov.javalessons.DTO.SocksDTO;


@Controller
@RequestMapping("/api/socks")
@Validated
public class SocksController {
	
	//TEST
	@GetMapping("/index")
	public String index() {
		return "socks/index";
	}
	
	@GetMapping("/result")
	public String result() {
		return "socks/result";
	}
	
	@GetMapping("/income")
	public String income(Model model) {
		model.addAttribute("socksDTO", new SocksDTO());
		return "socks/income";
	}
	
	@GetMapping("/outcome")
	public String outcome(Model model) {
		model.addAttribute("socksDTO", new SocksDTO());
		return "socks/outcome";
	}
	
	//main
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
	
	@PostMapping("/income")
	public String income(@ModelAttribute("socksDTO") @Valid SocksDTO socksDTO) {
		System.out.println("I am Here income");
		return "socks/result";
	}
	
	@PostMapping("/outcome")
	public String outcome(@ModelAttribute("socksDTO") @Valid SocksDTO socksDTO) {
		System.out.println("I am Here outcome");
		return "socks/result";
	}
}
