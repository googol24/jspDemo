import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SessionInfoServlet", urlPatterns = "/servlet/sessionInfo")
public class SessionInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // 创建一个包含session信息的HTML文档，并且返回到客户端
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取当前的Session，如果没有的话创建一个新的Session
        // false表示如果没有的话返回null
        HttpSession session = request.getSession(true);

        // 指定响应类型
        response.setContentType("text/html;charset=utf-8");

        // 获取响应的输出字符流
        PrintWriter out = response.getWriter();

        // 生成HTML响应
        out.println("<html>");
        out.println("<head><title>Session Info Servlet</title></head>");
        out.println("<body>");
        out.println("<h3>Session Information:</h3>");
        out.println("是否是新的Session：" + session.isNew());
        out.println("<br>Session ID：" + session.getId());
        out.println("<br>Session的创建时间：" + new Date(session.getCreationTime()));
        out.println("<br>Session的最后修改时间：" + new Date(session.getLastAccessedTime()));

        out.println("<h3>Request Information：</h3>");
        out.println("请求的Session Id：" + request.getRequestedSessionId());
        out.println("<br>Session Id是否存储在Cookie上：" + request.isRequestedSessionIdFromCookie());
        out.println("<br>Session Id是否通过URL重写实现：" + request.isRequestedSessionIdFromURL());
        out.println("<br>Session Id是否合法：" + request.isRequestedSessionIdValid());

        // 刷新
        out.println("<br><a href=" + "sessionInfo" + ">刷新</a>");
//        out.println("<br><a href=" + response.encodeURL("sessionInfo") + ">刷新</a>");

        out.println("</body>");
        out.println("</html>");

        out.close();

    }
}
