package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private final String postgreDriver = "org.postgresql.Driver";
    private final String userNamePostgre = "admin";
    private final String userPassPostgre = "arda10021";
    private final String url2 = "jdbc:postgresql://localhost:5432/jdbc_join";


    public Connection connection = null;

    public DB() {
        try {
            Class.forName(postgreDriver);
            connection = DriverManager.getConnection(url2,userNamePostgre,userPassPostgre);
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
