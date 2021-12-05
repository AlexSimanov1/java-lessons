package ru.simanov.javalessons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.simanov.javalessons.models.Socks;
import ru.simanov.javalessons.models.SocksDAO;



@Component
public class SocksService {
	
	@Autowired
	private SocksDAO socksDAO;
	
	public String income(Socks incomeSocks) {
		System.out.println("income\n" + incomeSocks);
		
		socksDAO.save(incomeSocks);
		
		return "success";
	}
	
	
	public String outcome(Socks incomeSocks) {
		System.out.println("outcome\n" + incomeSocks);
		return "success";
	}

}
