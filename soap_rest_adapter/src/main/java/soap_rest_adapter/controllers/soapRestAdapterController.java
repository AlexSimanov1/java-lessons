package soap_rest_adapter.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import soap_rest_adapter.models.CalculatedData;
import soap_rest_adapter.models.SoapCalculator;

@Controller
@RequestMapping("/soap")
@Validated
public class soapRestAdapterController {
	@Autowired
	private SoapCalculator soapCalculator;

	@GetMapping("/test")
	public String openTestWindow(Model model) {
		model.addAttribute("calculatedData", new CalculatedData());
		return "test_window";
	}
	
	@PostMapping("test")
	public ResponseEntity<String> requestToSoap(@ModelAttribute("calculatedData") @Valid CalculatedData calculatedData) {
		soapCalculator.setCalculateData(calculatedData);
		soapCalculator.request();
		return ResponseEntity.ok(soapCalculator.getResponse());
	}
}
