import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement login logic
        // 1. Get username & password from request
        // 2. Validate credentials (hardcode a few users)
        // 3. If valid:
        //    - Create session
        //    - Store username in cookie
        //    - Redirect to DashboardServlet
        // 4. If invalid, redirect back to login.html

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ((username.equals("student1") && password.equals("pass1")) ||
                (username.equals("student2") && password.equals("pass2"))) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);

            response.sendRedirect("DashboardServlet");
        } else {
            response.getWriter().println("Invalid credentials.");
        }
    }
}