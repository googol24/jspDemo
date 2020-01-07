import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ShowCookieServlet")
public class ShowCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取客户端的Cookie并显示
        Cookie[] cookies = request.getCookies();

        PrintWriter out = response.getWriter();

        for (Cookie cookie : cookies) {
            out.println("COOKIE_NAME:" + cookie.getName() + ", COOKIE_VALUE:" + cookie.getValue());
        }
    }
}
