package soap_rest_adapter.services;

import org.springframework.stereotype.Service;

import soap_rest_adapter.models.CalculatedData;

@Service
public class SoapCalculatorService {
	
	//@Autowired
	//private CalculatedData calculatedData;
	
	public int calc(CalculatedData calculatedData) {
		int result = 0;
		if (calculatedData.getOperation().equals("add")) {
			result = calculatedData.getA() + calculatedData.getB();
		} else if (calculatedData.getOperation().equals("divide")) {
			result = calculatedData.getA() / calculatedData.getB();
		} else if (calculatedData.getOperation().equals("multiply")) {
			result = calculatedData.getA() * calculatedData.getB();
		} else if (calculatedData.getOperation().equals("subtract")) {
			result = calculatedData.getA() - calculatedData.getB();
		}
		return result;
	}
}
