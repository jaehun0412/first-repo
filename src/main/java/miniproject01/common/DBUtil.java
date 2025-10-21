package miniproject01.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/library";
        String user = "jaehun";
        String password = "lion1234";

        return DriverManager.getConnection(url, user, password);
    }
}
