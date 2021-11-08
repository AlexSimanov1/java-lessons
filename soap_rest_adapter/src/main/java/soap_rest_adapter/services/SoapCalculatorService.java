package soap_rest_adapter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import soap_rest_adapter.models.Operation;
import soap_rest_adapter.models.SoapCalculator;

@Service
public class SoapCalculatorService {
	@Autowired
	private SoapCalculator soapCalculator;

	@Cacheable(cacheNames="calculatedData")
	public String calcCashe(int a, int b, String operation) {
		String result = "";
		
		switch(Operation.valueOf(operation)) {
		case Add:
			result = soapCalculator.add(a, b);
			break;
		case Multiply:
			result = soapCalculator.multiply(a, b);
			break;
		case Divide:
			result = soapCalculator.divide(a, b);
			break;
		case Subtract:
			result = soapCalculator.subtract(a, b);
			break;
		default:
			break;
		}
		return result;
	}
}
