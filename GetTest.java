import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class GetTest {
  public static void main(String[] args) {
    try {
      String result = new Get("http://post-server.herokuapp.com/sales").execute();

      System.out.println(result);

      Gson gson = new Gson();
      SaleRecord[] records = gson.fromJson(result, SaleRecord[].class);

      for( SaleRecord record : records ){
        System.out.println(record);
      }
    } catch( Exception ex ) {
      ex.printStackTrace();
    }
  }
}

class SaleRecord {
  private int id;
  @SerializedName("sale_data")
  private SaleData saleData;

  @Override
  public String toString() {
    return "**** " + id + " ****\n" + saleData;
  }
}

enum TenderedType {
  CASH, CHECK, CREDIT
}

class Tendered {
  private TenderedType type;
  private double amount;

  @Override
  public String toString() {
    return type + " Tendered: " + amount;
  }
}

class SaleData {
  private String customer;
  private Date timeOfSale;
  private Item[] items;
  private double total;
  private Tendered tendered;
  private double returned;

  @Override
  public String toString() {
    StringBuilder buffer = new StringBuilder();

    buffer.append( customer ).append( " @ " ).append( timeOfSale ).append( "\n" );

    for( Item item : items ) {
      buffer.append( item ).append("\n");
    }

    buffer.append(tendered).append("\n");

    buffer.append("Returned: ").append( returned );

    return buffer.toString();
  }
}

class Item {
  private String upc;
  private int quantity;
  private double price;

  @Override
  public String toString() {
    return upc + " " + quantity + " @ " + price;
  }
}