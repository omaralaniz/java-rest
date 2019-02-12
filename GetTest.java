import java.net.MalformedURLException;
import java.io.IOException;

public class GetTest {
  public static void main(String[] args) {
    try {
      Get request = new Get("http://post-server.herokuapp.com/sales");
      String result = request.execute();

      System.out.println(result);
    } catch( MalformedURLException mex ) {
      mex.printStackTrace();
    } catch( IOException iex ) {
      iex.printStackTrace();
    }
  }
}