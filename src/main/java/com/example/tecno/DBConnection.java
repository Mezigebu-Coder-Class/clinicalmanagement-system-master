package com.example.tecno;
    import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
    public class DBConnection {


        Connection conn=null;

      public Connection ConnectDb() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/clinical-management","root", "");
                System.out.print("Database is connected !");
               this.conn = conn;
            }
            catch(Exception e) {
                System.out.print("Do not connect to DB Error:"+e);
            }
          return this.conn;
      }
    }

