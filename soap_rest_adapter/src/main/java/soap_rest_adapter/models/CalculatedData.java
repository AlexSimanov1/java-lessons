package soap_rest_adapter.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class CalculatedData {
	private int a;
	private int b;
	
	@NotEmpty
	private String operation;
	
	public CalculatedData() {
	}
	
	public CalculatedData(int a, int b, String operation) {
		setA(a);
		setB(b);
		setOperation(operation);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
