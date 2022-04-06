package sesion;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        HttpSession session = request.getSession(true);

        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        
        session.setAttribute("usr", usr);
        session.setAttribute("pwd", pwd);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login_ok.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
