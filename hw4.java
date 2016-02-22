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
	Statement stmt = conn.createStatement ();
  
    while(true) { 
        System.out.println("\nPlease choose from the selection below:");
	    System.out.println("1: States queries");
	    System.out.println("2: ND Player queries");
	    System.out.println("0: Exit");

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
        		System.out.println("1: List of players from a particular state");
        		System.out.println("2: Number of players from a particular state");
        		System.out.println("3: Number of players in each region");	
        		System.out.println("4: Weight by position for each class");	
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
					
						//execute query
						ResultSet rs = stmt.executeQuery (q);
						if( !rs.next() ){ 
        					System.out.println ("There are no players from "+state+". ");
						} else {
        				System.out.println ("Players from "+state+": ");
						while(rs.next())
							System.out.println ("#"+rs.getString (1)+" "+rs.getString (3)+" "+rs.getString (2)+" is from "+rs.getString (4)+", "+rs.getString (5));
						}
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
/*
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

