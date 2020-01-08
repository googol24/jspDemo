import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ShowRsUseBean", urlPatterns = "/servlet/showRsUseBean")
public class ShowRsUseBean extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("<table border=1>");
        out.println("<tr><th>name</th><th>tel</th></tr>");

        // 连接数据库读取数据
        Connection conn = DB.getConnection();
        Statement statement = DB.getStatement(conn);
        ResultSet resultSet = DB.getResultSet(statement, "SELECT * FROM t3");
        try {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String tel = resultSet.getString("tel");
                out.println("<tr>");
                out.println("<td>" + name +"</td>");
                out.println("<td>" + tel +"</td>");
                out.println("</tr>");
            }
            out.println("</table>");

        } catch (SQLException e) {
            System.out.println("Sql 异常：" + e.getMessage());
            e.printStackTrace();
        } finally {
            DB.close(resultSet);
            DB.close(statement);
            DB.close(conn);
        }
    }
}
