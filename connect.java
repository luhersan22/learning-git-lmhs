    import java.sql.*;  
    import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientSettings;

    class OracleCon {  
        public static void main(String args[]) {  
            try{  
            // ...
            ConnectionString connString = new ConnectionString(
                "mongodb+srv://<username>:<password>@<cluster-address>/test?w=majority"
            );
            MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
            MongoClient mongoClient = MongoClients.create(settings);
            MongoDatabase database = mongoClient.getDatabase("test");

            connectSQL();
                
            } catch(Exception e) { 
                System.out.println(e);
            }  
        }  

        public Connection connectSQL() {
            Connection conn = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user", this.userName);
            connectionProps.put("password", this.password);
        
            if (this.dbms.equals("mysql")) {
                conn = DriverManager.getConnection(
                           "jdbc:" + this.dbms + "://" +
                           this.serverName +
                           ":" + this.portNumber + "/",
                           connectionProps);
            } else if (this.dbms.equals("derby")) {
                conn = DriverManager.getConnection(
                           "jdbc:" + this.dbms + ":" +
                           this.dbName +
                           ";create=true",
                           connectionProps);
            }
            System.out.println("Connected to database");
            return conn;
        }
    }  
    class OracleCon{  
    public static void main(String args[]){  
    try{  
        //step1 load the driver class  
        Class.forName("oracle.jdbc.driver.OracleDriver");  

        //step2 create  the connection object  
        Connection con=DriverManager.getConnection(  
        "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  

        //step3 create the statement object  
        Statement stmt=con.createStatement();  

        //step4 execute query  
        ResultSet rs=stmt.executeQuery("select * from emp");  
        while(rs.next())  
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  

        //step5 close the connection object  
        con.close();  

        }catch(Exception e){ 
            System.out.println(e);    
        }  
        
        
        try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/sonoo","root","root");  
        //here sonoo is database name, root is username and password  
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from emp");  
        while(rs.next())  
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
        con.close();  
        }catch(Exception e){ System.out.println(e);}  
        }  
      
    }  
    }  
