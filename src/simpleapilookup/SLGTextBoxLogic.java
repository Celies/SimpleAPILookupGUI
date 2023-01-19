package simpleapilookup;
/**
 * Class containing the logic behind the URL resolve and also stores the text that is generated from that call. 
 *
 */
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class SLGTextBoxLogic {
	private String text;
	
	public SLGTextBoxLogic() {
		text = new String();
	}
	
	public boolean resolveURL(String url) {
		
		HttpRequest request = null;
		HttpResponse<String> response = null;
		boolean success = true;
		
		try {
			request = HttpRequest.newBuilder()
					  .uri(new URI(url))
					  .GET()
					  .build();
		} catch (URISyntaxException e1) {
			success = false;
			e1.printStackTrace();
			text = e1.getMessage();
		}
		HttpClient client = HttpClient.newHttpClient();
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
			text = e.getMessage();
		} catch (InterruptedException e) {
			success = false;
			e.printStackTrace();
			text = e.getMessage();
		}
		
		text = response.body();
		
		return success;
	}
	public String getMessage() {
		return text;
	}
}
