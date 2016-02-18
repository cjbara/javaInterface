import java.sql.*;
import java.io.*;

class region
{
  public static void main (String args [])
       throws SQLException
  {
    String connstr = "jdbc:sqlite:states.db";
    Connection conn = DriverManager.getConnection (connstr);
				   
    Statement stmt = conn.createStatement ();
    String query = "select region from regions";

    ResultSet rs = stmt.executeQuery (query);

    // Iterate through the result and display the results
    System.out.println("The regions are:");
    while (rs.next ()) {
      System.out.println (rs.getString (1));
    }

    rs.close(); stmt.close(); conn.close();
  }
}

