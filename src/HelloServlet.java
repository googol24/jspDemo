import java.io.*;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

    private String message;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("doPost......");
        response.getWriter().println("post param1:" + request.getParameter("param1"));

        // 使用map遍历所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            StringBuilder value = new StringBuilder();
            for (String val : entry.getValue()) {
                value.append(",").append(val);
            }

            response.getWriter().println("param:" + entry.getKey() + ", value:" + value);
        }
    }

    // 客户端用GET方式请求Servlet时，会相应访问doGet方法
    // HttpServletRequest封装了客户端向Servlet的请求信息
    // HttpServletResponse封装了服务器端发送给客户端的响应信息
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("doGet......");

        // 指明返回的内容是html类型
        response.setContentType("text/html");

        // 设置逻辑实现
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        // request是实现了HttpServletRequest接口的类的对象
        out.println("<br/>");
        out.println("<h2>param:" + request.getParameter("param") + "</h2>");
        out.println("<h2>context path:" + request.getContextPath() + "</h2>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init......");
        this.message = "Hello world, this message is from servlet!";
    }

    @Override
    public void destroy() {
        System.out.println("destroy......");
        super.destroy();
    }
}
