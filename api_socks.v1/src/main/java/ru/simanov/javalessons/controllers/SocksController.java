package ru.simanov.javalessons.controllers;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api/socks")
@Validated
public class SocksController {

	@GetMapping("/getSocks")
	public String greeting() {
		return "hello_page";
	}
	
	@GetMapping("/getTest")
	public String getTestPost() {
		return "test_post";
	}
	
	@PostMapping("/testPost")
	public String testPost() {
		System.out.print("I am Here");
		return "resultPage";
	}
	
	//main TEST
	@GetMapping("/index")
	public String index() {
		return "socks/index";
	}
	
	@GetMapping("/result")
	public String result() {
		return "socks/result";
	}
	
	//main
	@GetMapping()
	public String getSumSocks(@RequestParam String color
			                 ,@RequestParam String operation
			                 ,@RequestParam @Min(0) @Max(value = 100, message = "cotton part has to be less than or equal to 100") int cottonPart
			              ) {
		System.out.println(color);
		System.out.println(operation);
		System.out.println(cottonPart);
		return "socks/result";
	}
}
