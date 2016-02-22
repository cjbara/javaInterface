import java.sql.*;
import java.io.*;
import java.util.Scanner;

class query
{
  public static void main (String args [])
       throws SQLException
  {
    int a;
    int n;
    float b;
    Scanner reader = new Scanner(System.in);  // Reading from System.in

    String connstr = "jdbc:sqlite:states.db";
    Connection conn = DriverManager.getConnection (connstr);
   
    while(true) { 
        System.out.println("\nPlease choose from the selection below:");
	    System.out.println("1: States queries");
	    System.out.println("2: ND Player queries");
	    System.out.println("0: Exit");
/*
    System.out.println("Query 1: ");
    System.out.println("Query 2: ");
    System.out.println("Query 3: ");
    System.out.println("Query 4: ");
    System.out.println("Query 5: ");
    System.out.println("Query 6: ");
    System.out.println("Query 7: ");
    System.out.println("Query 8: ");
    System.out.println("Query 9: ");
    System.out.println("Query 10: ");
    System.out.println("Query 11: ");
    System.out.println("Query 12: ");
    //System.out.println("Query 13: ");
    //System.out.println("Query 14: ");
    System.out.println("Entering 0 will quit the program");
*/
        n = reader.nextInt(); // Scans the next token of the input as an int.
 
        String q;
		if(n == 0) {
			System.out.println("System exit");
			System.exit(0);
		} else if (n == 1) {
			System.out.println("States Queries");
		} else if (n == 2) {
			System.out.println("ND Roster Queries");
			Boolean flag = true;
			while(flag) {
				System.out.println("\nND Roster Queries: Please choose from the selection below:");
        		System.out.println("1: Number of players from each state");
        		System.out.println("2: Weight by position for each class");	
        		System.out.println("3: ");	
        		System.out.println("0: Go Back");
	
				n = reader.nextInt();
				
				switch(n) {
					case 0: 
						flag = false;
						break;
					case 1:  
        				System.out.println("Enter a state code to see which players are from that state");	
						String state = reader.next();
						q = "select jno, last, first, city, stcode from roster where stcode = '"+state+"';";
        				System.out.println(q);
                     	break;
            		case 2:  
						q = "Query 2";
                     	break;
            		case 3:  
						q = "Query 3";
                     	break;
					default:
						System.out.println("Please enter a valid number");
						break;
				}

			}
		} else {
			System.out.println("Please enter a valid number");
		}
       /* switch (n) {
            case 0:  inString = "Option 0";  //quits the program
                     System.out.println("System exit");
                     System.exit(0);
                     break;
            case 1:  inString = "Query 1";
                     break;
            case 2:  inString = "Query 2";
                     break;
            case 3:  inString = "Query 3";
                     break;
            case 4:  inString = "Query 4";
                     break;
            case 5:  inString = "Query 5";
                     break;
            case 6:  inString = "Query 6";
                     break;
            case 7:  inString = "Query 7";
                     break;
            case 8:  inString = "Query 8";
                     break;
            case 9:  inString = "Query 9";
                     break;
            case 10: inString = "Query 10";
                     break;
            case 11: inString = "Query 11";
                     break;
            case 12: inString = "Query 12";
                     break;
            default: inString = "Invalid selection";
                     break;
        }
        System.out.println(inString);
        System.out.println();
		
        Statement stmt = conn.createStatement ();
        String query = "select state from states";

        ResultSet rs = stmt.executeQuery (query);

        // Iterate through the result and display the results
        System.out.println("The states are:");
        while (rs.next ()) {
            System.out.println (rs.getString (1));
        }
*/		

    }

  
  }
}








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

class state
{
  public static void main (String args [])
       throws SQLException
  {
    String connstr = "jdbc:sqlite:states.db";
    Connection conn = DriverManager.getConnection (connstr);
           
    Statement stmt = conn.createStatement ();
    String query = "select state from states";

    ResultSet rs = stmt.executeQuery (query);

    // Iterate through the result and display the results
    System.out.println("The states are:");
    while (rs.next ()) {
      System.out.println (rs.getString (1));
    }

    rs.close(); stmt.close(); conn.close();
  }
}

class player_region
{
  public static void main (String args [])
       throws SQLException
  {
    String connstr = "jdbc:sqlite:states.db";
    Connection conn = DriverManager.getConnection (connstr);
           
    Statement stmt = conn.createStatement ();
    String query = "select r.region, players  from regions r join (select s.regcode as REGION, count(*) as PLAYERS from streg s join roster x on s.stcode = x.stcode group by s.regcode order by 2 desc, 1) s where r.regcode=s.region";

    ResultSet rs = stmt.executeQuery (query);

    // Iterate through the result and display the results
    System.out.println("The number of players from each region are:");
    while (rs.next ()) {
      System.out.print (rs.getString (1));
      System.out.print (":  ");

      System.out.println (rs.getString (2));
    }

    rs.close(); stmt.close(); conn.close();
  }
}

