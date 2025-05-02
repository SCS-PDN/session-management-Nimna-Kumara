import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement dashboard logic
        // 1. Check if user is logged in (session)
        // 2. Create a list of courses (hardcoded)
        // 3. Store courses in request attribute
        // 4. Forward to dashboard.jsp

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }

        Course course1 = new Course("CSC3012", "ServerSide", "Dr. A");
        Course course2 = new Course("CSC3022", "ImageLab", "Dr. B");
        Course course3 = new Course("CSC3032", "OOAD", "Dr. C");

        List<Course> courses = Arrays.asList(course1,course2,course3);

        request.setAttribute("courses", courses);

        @SuppressWarnings("unchecked")
        List<String> enrolled = (List<String>) session.getAttribute("enrolledCourses");
        if (enrolled == null) enrolled = new ArrayList<>();

        request.setAttribute("enrolledCourses", enrolled);

        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);

    }
}