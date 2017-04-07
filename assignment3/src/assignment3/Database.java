package assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Database {

    public Connection connectDatabase(){
        try{
            //Need a special jar file
            //I think it was sqlite.jdbc-3.7.2.jar
            //Not entirely sure cause i downloaded 4 of them
            //check github.com/xerial
            //Youtube a tutorial if needed
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Me\\Dropbox\\SEMESTER2\\test.db");
            System.out.println("Connection successful");
            return conn;
        }catch(Exception e){
            System.out.println("well fuck :" + e);
            return null;
        }
      }
    public Object[][] printData(String selected){
            Connection c = null;
            Statement stmt = null;
            List<String[]> holder = new ArrayList<String[]>();
            try {
              c = connectDatabase();
              c.setAutoCommit(false);
              System.out.println("Opened database successfully");

              stmt = c.createStatement();
              //ResultSet rs = stmt.executeQuery( "SELECT COUNT(*) FROM " + selected + ";" );
              //int rowsNumber = rs.getInt(1);
              
              ResultSet rs = stmt.executeQuery( "SELECT * FROM " + selected + ";" );
              ResultSetMetaData rsmd = rs.getMetaData();
              int columnsNumber = rsmd.getColumnCount();
              while ( rs.next() ) {
                  String[] tempHolder = new String[columnsNumber];
                  for (int j=0;j<columnsNumber;j++){
                      tempHolder[j]=rs.getString(j+1);
                      System.out.println(tempHolder[j]);
                  }
                  holder.add(tempHolder);
              }
              rs.close();
              stmt.close();
              c.close();
            } catch ( Exception e ) {
              System.err.println( e.getClass().getName() + ": " + e.getMessage() );
              System.exit(0);
            }
            //System.out.println("Operation done successfully");
            //Object[][] stringArray = holder.toArray(new String[0]);
            String[][] res = new String[holder.size()][];
            holder.toArray(res);
            return res;
    }
    public String getTableNames(){
        Connection c = null;
        Statement stmt = null;
        String tables = "";
        try {
            c = connectDatabase();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT name FROM sqlite_master WHERE type='table';" );
            while ( rs.next() ) {
                String name = rs.getString("name");
                tables += name + " ";
            }
            rs.close();
            stmt.close();
            c.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return tables;
    }
    public String[] getColNames(String selected){
        Connection c = null;
        Statement stmt = null;
        ArrayList<Object> holder = new ArrayList<Object>();
        //StringBuilder holder = new StringBuilder();
        try {
          c = connectDatabase();
          c.setAutoCommit(false);
          System.out.println("Opened database successfully");

          stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "PRAGMA table_info(" + selected + ");" );
          //ResultSetMetaData rsmd = rs.getMetaData();
          //int columnsNumber = rsmd.getColumnCount();
          //ArrayList<Object> holder = new ArrayList<Object>();
          while ( rs.next() ) {
                 holder.add(rs.getString(2));
                 //System.out.println(2);
                 //holder.append(" ");
             //holder.append("\n");
          }
          rs.close();
          stmt.close();
          c.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Operation done successfully");
        //return holder.toString();
        String[] names = holder.toArray(new String[holder.size()]);
        return names;
    }    
}
