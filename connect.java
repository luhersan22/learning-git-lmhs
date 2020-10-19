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