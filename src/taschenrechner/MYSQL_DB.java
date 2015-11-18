package taschenrechner;

//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;

public class MYSQL_DB implements DBAnbindung {
   // JDBC driver name and database URL
   static String  JDBC_DRIVER = "com.mysql.jdbc.Driver";      
   static String DB_URL = "jdbc:mysql://localhost/taschenrechner";

   static final String USER = "root";
   static final String PASS = "";
   
   private String sql;
   private Connection conn;
   private Statement stmt;
   private ResultSet rs;
   
   private ArrayList<Double> meineZahlen;
   
   public MYSQL_DB(){
       conn = null;
       stmt = null;
       meineZahlen = new ArrayList<>();
   }
   
   public void ausgabeDB() {
   
       anzahlBerechnungen();
       DurchschnittAllerZahlen();
       anzahlPlusOperationen();
       durchschnittLetzterNeunZahlen();
       

   System.out.println("Goodbye!");
}

        public void berechnungHinzufuegen(double eins, double zwei, double drei, String op1, String op2)
        {   
            try{
              Class.forName(JDBC_DRIVER).newInstance();
              conn = DriverManager.getConnection(DB_URL, USER, PASS);
              stmt = conn.createStatement();
              sql = "INSERT INTO tbl_berechnung " +
                      "VALUES ("+null+","+eins+","+zwei+","+drei+",'"+op1+"','"+op2+"')";
              stmt.executeUpdate(sql);
              System.out.println("Berechnung hinzugefügt");

           }catch(Exception e){
                System.out.println("Fehler bei try berechnungHinzufuegen");
           }
           finally{
              try{
                    stmt.close();
                    conn.close();
              }catch(Exception e){
                 System.out.println("Fehler beim Schließen berechnungHinzufuegen");
              }//end finally try
           }//end try

            ausgabeDB();
        }

        public void anzahlBerechnungen()
        {   
            try{
              Class.forName(JDBC_DRIVER).newInstance();
              conn = DriverManager.getConnection(DB_URL, USER, PASS);
              stmt = conn.createStatement();
              sql = "SELECT COUNT(BNr) FROM tbl_berechnung";
              ResultSet rs = stmt.executeQuery(sql);
              rs.next();
              System.out.println("Anzahl Berechnungen: " +rs.getString(1));

           }catch(Exception e){
                System.out.println("Fehler bei try anzahlBerechnungen");
           }
           finally{
              try{
                    stmt.close();
                    conn.close();
              }catch(Exception e){
                 System.out.println("Fehler beim Schließen anzahlBerechnungen");
              }//end finally try
           }//end try


        }

        public void DurchschnittAllerZahlen()
        {   
            try{
              Class.forName(JDBC_DRIVER).newInstance();
              conn = DriverManager.getConnection(DB_URL, USER, PASS);
              stmt = conn.createStatement();
              sql = "SELECT AVG((BZahl1+ BZahl2 + BZahl3)/3) AS durchschnitt FROM tbl_berechnung ";
              rs = stmt.executeQuery(sql);
              rs.next();
              System.out.println("Durchschnitt von allen Operanden: " +rs.getString(1));

           }catch(Exception e){
                System.out.println("Fehler bei try DurchschnittAllerZahlen");
           }
           finally{
              try{
                    stmt.close();
                    conn.close();
              }catch(Exception e){
                 System.out.println("Fehler beim Schließen DurchschnittAllerZahlen");
              }//end finally try
           }//end try


        }

        public void anzahlPlusOperationen()
        {   
            try{
              Class.forName(JDBC_DRIVER).newInstance();
              conn = DriverManager.getConnection(DB_URL, USER, PASS);
              stmt = conn.createStatement();
              sql = "SELECT COUNT(BNr) FROM tbl_berechnung WHERE BOp1='+' AND BOp2='+'";
              rs = stmt.executeQuery(sql);
              rs.next();
              System.out.println("Anzahl Berechnungen mit +-Operator: " +rs.getString(1));

           }catch(Exception e){
                System.out.println("Fehler bei try anzahlPlusOperationen");
           }
           finally{
              try{
                    stmt.close();
                    conn.close();
              }catch(Exception e){
                 System.out.println("Fehler beim Schließen anzahlPlus");
              }//end finally try
           }//end try
        }
        
        public void durchschnittLetzterNeunZahlen()
        {   
             
            try{
              Class.forName(JDBC_DRIVER).newInstance();
              conn = DriverManager.getConnection(DB_URL, USER, PASS);
              stmt = conn.createStatement();
              sql = "SELECT BZahl1, BZahl2, BZahl3 FROM tbl_berechnung ORDER BY BNr DESC LIMIT 3";
              rs = stmt.executeQuery(sql);

              double zw = 0;
              while(rs.next()) {
                  meineZahlen.add(rs.getDouble(1));
                  meineZahlen.add(rs.getDouble(2));
                  meineZahlen.add(rs.getDouble(3));
              }
              for( int i = 0; i<meineZahlen.size(); i++)
              {
                  zw = zw + meineZahlen.get(i);      
              }
              zw = zw / 9;
              System.out.println("Durchschnitt der letzten 9 Zahlen: " + zw);

           }catch(Exception e){
                System.out.println("Fehler bei try durchschnittLetzterZahlen");
           }
           finally{
              try{
                    stmt.close();
                    conn.close();
              }catch(Exception e){
                 System.out.println("Fehler beim Schließen durchschnittLetzterZahlen");
              }//end finally try
           }//end try
        }

    }