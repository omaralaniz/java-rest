import java.net.MalformedURLException;
import java.io.IOException;

public class PutTest {
  private static final String TEST_DATA = 
    "{ \"customer\": \"John Roberts\", \"timeOfSale\": \"2019-02-11T06:46:51.623Z\", \"items\": [ { \"upc\": \"1234\", \"quantity\": 2, \"price\": 123.45 } ], \"total\": 1234.56, \"tendered\": { \"type\": \"CASH\", \"amount\": 1235.56 }, \"returned\": 1.00 }";

  public static void main(String[] args) {
    try {
      Put request = new Put("http://post-server.herokuapp.com/sales");
      String result = request.execute(TEST_DATA);

      System.out.println(result);
    } catch( MalformedURLException mex ) {
      mex.printStackTrace();
    } catch( IOException iex ) {
      iex.printStackTrace();
    }
  }
}