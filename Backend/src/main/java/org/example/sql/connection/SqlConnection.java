package org.example.sql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SqlConnection {
    private static final String database = System.getenv("database");
    private static final String username = System.getenv("username");
    private static final String password =  System.getenv("password");;
    private static final String ipAddress = System.getenv("ip_address");
    private static final String tcpPort = System.getenv("TCP_Port");
    private static final String databaseName = System.getenv("database_name");

    private static Logger logger = Logger.getLogger(SqlConnection.class.getName());

    public static Connection startConnection() throws SQLException {

        String url =
                "jdbc:" + database +"://" + ipAddress + ":" + tcpPort + ";" +
                        "databaseName="+ databaseName+";" +
                        "encrypt=true;" +
                        "trustServerCertificate=true;";



        Connection connection = DriverManager.getConnection(url, username, password);

        if (connection != null) {
            logger.info("Connected to database successfully");
            return connection;
        }
        logger.severe("Failed to connect to database");
        return null;
    }
}
