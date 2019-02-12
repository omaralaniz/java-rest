import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;

public class Response {
  private int statusCode;
  private String result;
  private BufferedReader bodyReader;

  public Response( HttpURLConnection connection ) throws IOException{
    this.result = "";

    this.statusCode = connection.getResponseCode();

    this.bodyReader = new BufferedReader(
      new InputStreamReader(connection.getInputStream())
    );

    this.read();
  }

  public int getStatusCode() {
    return this.statusCode;
  }

  public String getBody() {
    return this.result;
  }

  private void read() throws IOException {
    String line;

    while(( line = bodyReader.readLine() ) != null ) {
      this.result = this.result + line;
    }
  }
}