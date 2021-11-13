package soap_rest_adapter.soapCalculator;

import org.springframework.web.reactive.function.client.WebClient;

public abstract class SoapCalculatorAbstract {
	protected String url;
	protected String xml;
	protected String xml_sample;
	
	protected WebClient webClient;
	
	public String calc(int a, int b) {
		xml = String.format(xml_sample, a, b);
		System.out.println(url);
		System.out.println(webClient);
		return request();
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
