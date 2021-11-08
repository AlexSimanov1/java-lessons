package soap_rest_adapter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soap_rest_adapter.models.CalculatedData;
import soap_rest_adapter.models.Operation;
import soap_rest_adapter.models.SoapCalculator;

@Service
public class SoapCalculatorService {
	@Autowired
	private SoapCalculator soapCalculator;
	
	public String calc(CalculatedData calculatedData) {
		String result = "";
		
		switch(Operation.valueOf(calculatedData.getOperation())) {
		case Add:
			result = soapCalculator.add(calculatedData.getA(), calculatedData.getB());
			break;
		case Multiply:
			result = soapCalculator.multiply(calculatedData.getA(), calculatedData.getB());
			break;
		case Divide:
			result = soapCalculator.divide(calculatedData.getA(), calculatedData.getB());
			break;
		case Subtract:
			result = soapCalculator.subtract(calculatedData.getA(), calculatedData.getB());
			break;
		default:
			break;
		}
		return result;
	}
}
