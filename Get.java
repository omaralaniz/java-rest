import java.io.IOException;
import java.net.MalformedURLException;

public class Get extends RestRequest {
  public Get( String uri ) throws MalformedURLException, IOException {
    super(uri);
    connection.setRequestMethod("GET");
  }

  public String execute() throws IOException {
      Response response = new Response( connection );

      connection.disconnect();

      return response.getBody();
  }
}