import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/servlet/showRs")
public class ShowRs extends HttpServlet{

    private static final String DB_URL = "jdbc:mysql://127.0.0.1/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<table border=1>");
        out.println("<tr><th>name</th><th>tel</th></tr>");

        // 连接数据库读取数据
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM t3");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String tel = resultSet.getString(2);
                out.println("<tr>");
                out.println("<td>" + name +"</td>");
                out.println("<td>" + tel +"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (ClassNotFoundException e) {
            System.out.println("未找到驱动类!");
        } catch (SQLException e) {
            System.out.println("Sql 异常：" + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
