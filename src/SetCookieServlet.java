import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置Cookie
        for (int i = 0; i < 3; i++) {
            Cookie c = new Cookie("SESSION_COOKIE_" + i, "SESSION_VALUE_S" + i);
            response.addCookie(c);

            c = new Cookie("PERSISTENT_COOKIE_" + i, "PERSISTENT_VALUE_P" + i);
            c.setMaxAge(3600);
            response.addCookie(c);
        }

        // 发送给浏览器要显示的数据
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<h2>Set Cookies Page</h2>");
        pw.println("<h3>Cookies has been set</h3>");
        pw.println("<h3><a href='ShowCookieServlet'>Show Cookies</a><h3>");
    }
}
