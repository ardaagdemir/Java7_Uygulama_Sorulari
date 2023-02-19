package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url1 = "jdbc:mysql://localhost:3306/bilgeadam_uygulama?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey&useSSL=false";
    private final String username = "root";
    private final String userpass = "";


    public Connection connection = null;

    public DB() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url1,username,userpass);
            if (!connection.isClosed()){
                System.out.println("Connection Success");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
