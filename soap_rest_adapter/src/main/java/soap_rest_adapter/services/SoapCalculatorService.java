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
		
		if (calculatedData.getOperation().equals("Add")) {
			result = soapCalculator.add(calculatedData.getA(), calculatedData.getB());
		} else if (calculatedData.getOperation().equals("Divide")) {
			result = soapCalculator.divide(calculatedData.getA(), calculatedData.getB());
		} else if (calculatedData.getOperation().equals("Multiply")) {
			result = soapCalculator.multiply(calculatedData.getA(), calculatedData.getB());
		} else if (calculatedData.getOperation().equals("Subtract")) {
			result = soapCalculator.subtract(calculatedData.getA(), calculatedData.getB());
		}
		
		return result;
	}
}
