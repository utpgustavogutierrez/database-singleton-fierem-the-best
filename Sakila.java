import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sakila
{
  private Sakila()
  {
    try
    (
      // create a database connection
      Connection connection = DriverManager.getConnection("jdbc:sqlite:./sqlite-sakila.db");
      Statement statement = connection.createStatement();
    )
    {
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      ResultSet rs = statement.executeQuery("select * from film");
      while(rs.next())
      {
        // read the result set
        System.out.println("title = " + rs.getString("title"));
      }
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory",
      // it probably means no database file is found
      e.printStackTrace(System.err);
    }
  }

  public static sincronizacion Sakila getInstance(){
      if(instance == null) {
          instance = new Sakila();
      }
    return instance;
  }

  public static void main(String[] args)
  {
    Sakila database = Sakila.getInstance();
    System.out.println(database.Sakila())
  }
}
