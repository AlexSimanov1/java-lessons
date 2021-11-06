package soap_rest_adapter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soap_rest_adapter.models.CalculatedData;
import soap_rest_adapter.models.SoapCalculator;

@Service
public class SoapCalculatorService {
	@Autowired
	private SoapCalculator soapCalculator;
	
	public String calc(CalculatedData calculatedData) {
		String result = "";
		//SoapCalculator soapCalculator = new SoapCalculator();
		//result = soapCalculator.add(calculatedData.getA(), calculatedData.getB());
		/*
		if (calculatedData.getOperation().equals("add")) {
			//result = SoapCalculator.add();
			result = calculatedData.getA() + calculatedData.getB();
		} else if (calculatedData.getOperation().equals("divide")) {
			result = calculatedData.getA() / calculatedData.getB();
		} else if (calculatedData.getOperation().equals("multiply")) {
			result = calculatedData.getA() * calculatedData.getB();
		} else if (calculatedData.getOperation().equals("subtract")) {
			result = calculatedData.getA() - calculatedData.getB();
		}
		*/
		return result;
	}
}
