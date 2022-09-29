package db;

import java.sql.*;

public class DB {

    static String url = "jdbc:mysql://localhost:3306/coursejdbc?characterEncoding=utf8";
    static String user = "developer";
    static String pass = "1234567";

    private static Connection conn = null;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e1) {
            System.out.println("Driver não disponível");
        }

        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Connected with database");

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

}