package ru.simanov.javalessons.services;

import java.util.Optional;

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
		Optional<Sock> sockOpt = socksDAO.findByColorAndCottonPart(socksForm.getColor(), socksForm.getCottonPart());
		
		sockOpt.ifPresentOrElse(
				sock -> {
					sock.setQuantity(sock.getQuantity() + socksForm.getQuantity());
					socksDAO.saveSock(sock);
					},
				() -> socksDAO.saveSock(new Sock(socksForm.getColor(), socksForm.getCottonPart(), socksForm.getQuantity())));
		return "test. income ";
	}
	
	public String outcome(SocksForm socksForm) {
		Optional<Sock> sockOpt = socksDAO.findByColorAndCottonPart(socksForm.getColor(), socksForm.getCottonPart());
		
		sockOpt.stream()
			.forEach(sock -> {
				if (sock.getQuantity() < socksForm.getQuantity()) {
					//Exception
				} else {
					sock.setQuantity(sock.getQuantity() - socksForm.getQuantity());
					socksDAO.saveSock(sock);
				}
			});
			
		return "test. outcome";
	}
}
