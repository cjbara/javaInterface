import java.sql.*;
import java.io.*;

class player
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
      System.out.print ("  " + rs.getString(1) + ", " + rs.getString(2));
      System.out.print (" is ");
      System.out.println(rs.getFloat(3) + "'" + rs.getFloat(4) + "\" tall.");
    }

    rs.close(); stmt.close(); conn.close();
  }
}

