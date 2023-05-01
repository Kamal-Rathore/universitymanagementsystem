
package university.management.system;

/* 
steps for establishing connection 
1. register the driver class
2. establishing the connection
3. creating statement
4. executing the SQL Queries
5. closing the connection */

import java.sql.*;
 
public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // registering the driver class
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","123456");
            s= c.createStatement();
            
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
}
