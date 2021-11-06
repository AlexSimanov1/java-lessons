package soap_rest_adapter.models;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class SoapCalculator {
	private String url;
	private String xml;
	private StringBuffer response = new	StringBuffer();
	
	public void request() {
		String inputLine;

		try {
			URL obj = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
			connection.setDoOutput(true);
			
			DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
			outputStream.writeBytes(xml);
			outputStream.flush();
			outputStream.close();
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while ((inputLine = bufferedReader.readLine()) != null) {
				response.append(inputLine);
			}
			bufferedReader.close();
			
		} catch (Exception e) {
			System.out.println("exception" + e);
		}
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
	public void setXML(String xml) {
		this.xml = xml;
	}
	
	public String getResponse() {
		return response.toString();
	}
	
	public void setCalculateData(CalculatedData calculatedData) {
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
		
		setURL(url);
		setXML(xml);
	}
}
