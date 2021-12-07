package ru.simanov.javalessons.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.simanov.javalessons.dao.SocksDAO;
import ru.simanov.javalessons.entities.Sock;
import ru.simanov.javalessons.models.SocksForm;

@Component
public class SocksService {
	
	@Autowired
	private SocksDAO socksDAO;

	public String income(SocksForm socksForm) {
		Sock sock = socksDAO.findByColorAndCottonPart(socksForm.getColor(), socksForm.getCottonPart());
		return "test. income " + sock.getQuantity();
	}
	
	public String outcome(SocksForm socksForm) {
		return "test. outcome";
	}
	
	/*
	private Sock findByColorAndCottonPart(SocksForm socksForm) {
		Sock sock = null;
		try {
			sock = socksDAO.findByColorAndCottonPart(socksForm.getColor(), socksForm.getCottonPart());
		} catch (Exception e) {
			sock = new Sock(socksForm.getColor(), socksForm.getCottonPart(), socksForm.getQuantity());
		}
		return sock;
	}
	*/
}
