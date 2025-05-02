import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement enrollment logic
        // 1. Get courseId from URL parameter
        // 2. Get current user's session
        // 3. Add course to enrolled list in session
        // 4. Redirect back to DashboardServlet

        String courseId = request.getParameter("courseId");
        HttpSession session = request.getSession(false);

        if (session != null && courseId != null) {
            List<String> enrolledList = (List<String>) session.getAttribute("enrolledCourses");
            if (enrolledList == null) {
                enrolledList = new ArrayList<>();
            }
            if (!enrolledList.contains(courseId)) {
                enrolledList.add(courseId);
                session.setAttribute("enrolledCourses", enrolledList);
            }
        }

        response.sendRedirect("DashboardServlet");



    }
}