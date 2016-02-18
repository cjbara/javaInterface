import java.sql.*;
import java.io.*;
import java.util.Scanner;

class prep
{
  public static void main (String args [])
       throws SQLException, IOException
  {
    Connection conn = DriverManager.getConnection ("jdbc:sqlite:states.db");
  
    String query = "select last, first from roster";
    query += " where lower(position) = lower(?) ";
    query += " and weight >= ? ";

    PreparedStatement stmt = conn.prepareStatement (query);

    Scanner in = new Scanner(System.in);
    String pos;
    float wgt;
    ResultSet rs;

    System.out.print("Enter a player position: ");
    pos = in.nextLine().trim();
    System.out.print("Enter a minimum weight: ");
    wgt = in.nextFloat();

    stmt.setString (1, pos);
    stmt.setFloat (2, wgt);

    stmt.execute();
    rs = stmt.getResultSet();
    if (!rs.next()) {
      System.out.println (" nothing found");
    } else {
      System.out.print("Players who play " + pos);
      System.out.print(" with a minimum weight of ");
      System.out.println(wgt + " are:");
      do {
        System.out.println ("\t" + rs.getString(2) + " " + rs.getString(1));
      } while(rs.next());
    }

    rs.close(); stmt.close(); conn.close();
  }
}

