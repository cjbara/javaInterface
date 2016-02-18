import java.sql.*;
import java.io.*;

class player2
{
  public static void main (String args [])
       throws SQLException
  {
    String connstr = "jdbc:sqlite:states.db";
    Connection conn = DriverManager.getConnection (connstr);
				   
    Statement stmt = conn.createStatement ();
    String query = "select last, first, height_ft, height_in";
    query += " from roster";
    query += " where position = 'Linebacker'";

    ResultSet rs = stmt.executeQuery (query);

    // Iterate through the result and display the results
    while (rs.next ()) {
      System.out.print ("  " + rs.getString("last") + ", " + rs.getString("first"));
      System.out.print (" is ");
      System.out.println(rs.getFloat("height_ft") + "'" + rs.getFloat("height_in") + "\" tall.");
    }

    rs.close(); stmt.close(); conn.close();
  }
}

