package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    JavaBeans usuario = new JavaBeans();
    DAO dao = new DAO();

    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ...
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String name2 = request.getParameter("name2");
        String senha = request.getParameter("senha2");

        if (dao.validarUsuario(name2, senha)) {
            response.sendRedirect("init.html");
        } else {
            response.sendRedirect("erro.html");
        }
    }
}
