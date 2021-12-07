package ru.simanov.javalessons.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import ru.simanov.javalessons.dao.BankAccountDAO;
import ru.simanov.javalessons.exception.BankTransactionException;
import ru.simanov.javalessons.model.SendMoneyForm;

@Controller
@RequestMapping(value = "/sendMoney", headers = "Content-Type=application/json")
public class MainController {
	
	private Gson gson = new Gson();

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@PostMapping
	public ResponseEntity<String> sendMoney(@RequestBody String json) {
		SendMoneyForm sendMoneyForm;
		
		try {
			sendMoneyForm = gson.fromJson(json, SendMoneyForm.class);
			bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), sendMoneyForm.getToAccountId(), sendMoneyForm.getAmount());
		} catch(BankTransactionException e) {
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body(e.toString());
		}

		return ResponseEntity.ok(json);
	}
	
}
