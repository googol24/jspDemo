import java.sql.*;

public class DB {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("未找到驱动类！");
        } catch (SQLException e) {
            System.out.println("SQL异常：" + e.getMessage());
        }

        return connection;
    }

    static Statement getStatement(Connection conn) {
        Statement statement = null;

        try {
            if (conn != null) {
                statement = conn.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    static ResultSet getResultSet(Statement stmt, String sql) {
        ResultSet resultSet = null;

        try {
            if (stmt != null) {
                resultSet = stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
