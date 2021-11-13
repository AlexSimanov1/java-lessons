package soap_rest_adapter.soapCalculator;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DivideOperation extends SoapCalculatorAbstract {
	public DivideOperation(WebClient webClient) {
		url = "http://www.dneonline.com/calculator.asmx?op=Divide";
		xml_sample = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
				+ "  <soap12:Body>\r\n"
				+ "    <Divide xmlns=\"http://tempuri.org/\">\r\n"
				+ "      <intA>%d</intA>\r\n"
				+ "      <intB>%d</intB>\r\n"
				+ "    </Divide>\r\n"
				+ "  </soap12:Body>\r\n"
				+ "</soap12:Envelope>";
		this.webClient = webClient;
	}
}
