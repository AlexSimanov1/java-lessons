package ru.simanov.javalessons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/socks")
public class SocksController {

	@GetMapping("/getSocks")
	public String greeting() {
		return "hello_page";
	}
}
