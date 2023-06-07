package com.example.gestion_consultation.servlet;

import com.example.gestion_consultation.Entity.User;
import com.example.gestion_consultation.service.UserService;
import com.example.gestion_consultation.util.Description;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.event.service.spi.JpaBootstrapSensitive;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet(name = "login",value = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;
    public void init(){
        userService = new UserService();
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if(request.getParameter("type")!=null){
            String type = request.getParameter("type");
            request.setAttribute("type",type);
            request.getRequestDispatcher(Description.PATH_VIEWS+"login.jsp").forward(request,response);
        }
        if(request.getParameter("quit")!=null){
            session.setAttribute("isLogged",false);
            response.sendRedirect("patient");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("type") != null) {
            String type = request.getParameter("type");
            if (type.equals("login")) {

                String username = request.getParameter("username");
                System.out.println(username);
                String password = request.getParameter("password");

                User user = userService.findByUsername(username);
                if (user != null) {
                    if (BCrypt.checkpw(password,user.getPassword())) {
                        session.setAttribute("isLogged", true);
                        response.sendRedirect("patient");
                    }
                    else{
                        response.sendRedirect("patient");
                    }
                }
            } else {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String hasedPw = BCrypt.hashpw(password,BCrypt.gensalt(10));
                User user = userService.findByUsername(username);
                if (user == null) {
                    User userCreate = new User(username,hasedPw);
                    if(userService.create(userCreate)){
                        session.setAttribute("isLogged", true);
                        response.sendRedirect("patient");
                    }
                }
            }
        }
    }

    public void destroy(){
        userService.end();
    }
}
