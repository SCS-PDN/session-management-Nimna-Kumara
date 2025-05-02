import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement logout logic
        // 1. Invalidate session
        // 2. Remove username cookie
        // 3. Redirect to login.html

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }


        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    cookie.setMaxAge(0); // Expire the cookie
                    response.addCookie(cookie);
                }
            }
        }

      
        response.sendRedirect("login.html");
    }
}