package soap_rest_adapter.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SoapCalculator {
	@Autowired
	private WebClient webClient;
	private String url;
	private String xml;
	
	public String add(int a, int b) {
		url = "http://www.dneonline.com/calculator.asmx?op=Add";
		xml = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
						+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
						+ "  <soap12:Body>\r\n"
						+ "    <Add xmlns=\"http://tempuri.org/\">\r\n"
						+ "      <intA>%d</intA>\r\n"
						+ "      <intB>%d</intB>\r\n"
						+ "    </Add>\r\n"
						+ "  </soap12:Body>\r\n"
						+ "</soap12:Envelope>", a, b);
		return this.request();
	}

	public String divide(int a, int b) {
		url = "http://www.dneonline.com/calculator.asmx?op=Divide";
		xml = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
						+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
						+ "  <soap12:Body>\r\n"
						+ "    <Divide xmlns=\"http://tempuri.org/\">\r\n"
						+ "      <intA>%d</intA>\r\n"
						+ "      <intB>%d</intB>\r\n"
						+ "    </Divide>\r\n"
						+ "  </soap12:Body>\r\n"
						+ "</soap12:Envelope>", a, b);
		return this.request();
	}
	
	public String multiply(int a, int b) {
		url = "http://www.dneonline.com/calculator.asmx?op=Multiply";
		xml = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
						+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
						+ "  <soap12:Body>\r\n"
						+ "    <Multiply xmlns=\"http://tempuri.org/\">\r\n"
						+ "      <intA>%d</intA>\r\n"
						+ "      <intB>%d</intB>\r\n"
						+ "    </Multiply>\r\n"
						+ "  </soap12:Body>\r\n"
						+ "</soap12:Envelope>", a, b);
		return this.request();
	}
	
	public String subtract(int a, int b) {
		url = "http://www.dneonline.com/calculator.asmx?op=Subtract";
		xml = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
						+ "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
						+ "  <soap12:Body>\r\n"
						+ "    <Subtract xmlns=\"http://tempuri.org/\">\r\n"
						+ "      <intA>%d</intA>\r\n"
						+ "      <intB>%d</intB>\r\n"
						+ "    </Subtract>\r\n"
						+ "  </soap12:Body>\r\n"
						+ "</soap12:Envelope>", a, b);
		return this.request();
	}
	
	private String request() {
		return webClient.post()
				.uri(url)
				.bodyValue(xml)
				.retrieve()
				.bodyToMono(String.class)
				.block();
	}
}
