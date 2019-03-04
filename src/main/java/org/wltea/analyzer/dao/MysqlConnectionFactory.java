package org.wltea.analyzer.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class MysqlConnectionFactory {

    private static MysqlConnectionPool pool = new MysqlConnectionPool();

    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/ik_ext_dic";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "123456";

    static {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        List<Connection> connectionList = pool.getAccessList();
        if (connectionList.isEmpty()) {
            Connection connection = initConnection();
            pool.getUsingList().add(connection);
            return connection;
        }
        Connection connection = connectionList.remove(0);
        pool.getUsingList().add(connection);
        return connection;
    }

    private static Connection initConnection() {
        Connection connection = null;
        for (int i = 0; i < 5 && connection == null; i++ ) {
            try {
                connection = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void release(Connection connection) {
        pool.getUsingList().remove(connection);
        pool.getAccessList().add(connection);
    }



}
