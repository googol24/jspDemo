import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletContextServlet", urlPatterns = "/servletContext")
public class ServletContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 获取application对象
        ServletContext application = this.getServletContext();

        Integer accessCount = (Integer) application.getAttribute("access_count");

        if (accessCount == null) {
            accessCount = 0;
        } else {
            accessCount = accessCount + 1;
        }

        application.setAttribute("access_count", accessCount);

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Application追踪</title></head>"
                +   "<body bgColor=\"#FDF5E6\">\n"
                +   "<h1 align=\"center\">" + accessCount + "</h1>\n"
                +   "</body></html>"
        );

    }
}
