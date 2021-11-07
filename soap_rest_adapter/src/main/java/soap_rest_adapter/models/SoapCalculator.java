package soap_rest_adapter.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SoapCalculator {
	@Autowired
	private WebClient webClient;
	
	public String request(CalculatedData calculatedData) {
		String url = "";
		String xml = "";
		
		if (calculatedData.getOperation().equals("Add")) {
			url = "http://www.dneonline.com/calculator.asmx?op=Add";
			xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
					+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
					+ "  <soap12:Body>\r\n"
					+ "    <Add xmlns=\"http://tempuri.org/\">\r\n"
					+ "      <intA>" + calculatedData.getA() + "</intA>\r\n"
					+ "      <intB>" + calculatedData.getB() + "</intB>\r\n"
					+ "    </Add>\r\n"
					+ "  </soap12:Body>\r\n"
					+ "</soap12:Envelope>";
		} else if (calculatedData.getOperation().equals("Divide")) {
			url = "http://www.dneonline.com/calculator.asmx?op=Divide";
			xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
					+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
					+ "  <soap12:Body>\r\n"
					+ "    <Divide xmlns=\"http://tempuri.org/\">\r\n"
					+ "      <intA>" + calculatedData.getA() + "</intA>\r\n"
					+ "      <intB>" + calculatedData.getB() + "</intB>\r\n"
					+ "    </Divide>\r\n"
					+ "  </soap12:Body>\r\n"
					+ "</soap12:Envelope>";
		} else if (calculatedData.getOperation().equals("Multiply")) {
			url = "http://www.dneonline.com/calculator.asmx?op=Multiply";
			xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
					+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
					+ "  <soap12:Body>\r\n"
					+ "    <Multiply xmlns=\"http://tempuri.org/\">\r\n"
					+ "      <intA>" + calculatedData.getA() + "</intA>\r\n"
					+ "      <intB>" + calculatedData.getB() + "</intB>\r\n"
					+ "    </Multiply>\r\n"
					+ "  </soap12:Body>\r\n"
					+ "</soap12:Envelope>";
		} else if (calculatedData.getOperation().equals("Subtract")) {
			url = "http://www.dneonline.com/calculator.asmx?op=Subtract";
			xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
					+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
					+ "  <soap12:Body>\r\n"
					+ "    <Subtract xmlns=\"http://tempuri.org/\">\r\n"
					+ "      <intA>" + calculatedData.getA() + "</intA>\r\n"
					+ "      <intB>" + calculatedData.getB() + "</intB>\r\n"
					+ "    </Subtract>\r\n"
					+ "  </soap12:Body>\r\n"
					+ "</soap12:Envelope>";
		}
		
		return webClient.post()
				.uri(url)
				.bodyValue(xml)
				.retrieve()
				.bodyToMono(String.class)
				.block();
	}
}
