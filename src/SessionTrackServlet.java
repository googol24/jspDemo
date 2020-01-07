import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SessionTrackServlet", urlPatterns = "/sessionTrack")
// Session追踪
public class SessionTrackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession(true);

        String heading;

        Integer accessCount = (Integer) session.getAttribute("access_count");
        if (accessCount == null) {
            heading = "welcome, Newer!";
            accessCount = 0;
        } else {
            heading = "Welcome Back!";
            accessCount = accessCount + 1;
        }
        session.setAttribute("access_count", accessCount);

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Session追踪</title></head>"
                +   "<body bgColor=\"#FDF5E6\">\n"
                +   "<h1 align=\"center\">" + heading + "</h1>\n"
                +   "<h2>Information on you Session:<h2>\n"
                +   "<table border=1 align=\"center\"\n>"
                +   "<tr bgColor=\"#FFAD00\">\n" + "<th>Info Type<th>Value\n"
                +   "<tr>\n" + "    <td>ID\n" + "    <td>" + session.getId() + "\n"
                +   "<tr>\n" + "    <td>Creation Time\n" + "    <td>" + new Date(session.getCreationTime()) + "\n"
                +   "<tr>\n" + "    <td>Last Access Time\n" + "    <td>" + new Date(session.getLastAccessedTime()) + "\n"
                +   "<tr>\n" + "    <td>Number of Previous Access\n" + "    <td>" + accessCount + "\n"
                +   "</table>\n" + "</body></html>"
        );
    }
}
