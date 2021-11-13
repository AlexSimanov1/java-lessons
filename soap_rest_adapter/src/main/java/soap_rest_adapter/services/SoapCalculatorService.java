package soap_rest_adapter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import soap_rest_adapter.models.Operation;
import soap_rest_adapter.soapCalculator.AddOperation;
import soap_rest_adapter.soapCalculator.DivideOperation;
import soap_rest_adapter.soapCalculator.MultiplyOperation;
import soap_rest_adapter.soapCalculator.SoapCalculatorAbstract;
import soap_rest_adapter.soapCalculator.SubtractOperation;

@Service
public class SoapCalculatorService {
	
	private SoapCalculatorAbstract soapCalculator;
	@Autowired
	private WebClient webClient;
	
	private void setOperation(String operationName) {
		switch(Operation.valueOf(operationName)) {
		case Add:
			soapCalculator = new AddOperation(webClient);
			break;
		case Multiply:
			soapCalculator = new MultiplyOperation(webClient);
			break;
		case Divide:
			soapCalculator = new DivideOperation(webClient);
			break;
		case Subtract:
			soapCalculator = new SubtractOperation(webClient);
			break;
		default:
			break;
		}
	}

	@Cacheable(cacheNames="calculatedData")
	public String calcCashe(int a, int b, String operation) {
		setOperation(operation);
		return soapCalculator.calc(a, b);
	}
}
