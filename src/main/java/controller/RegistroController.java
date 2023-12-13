package controller;

import model.DAO;
import model.JavaBeans;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registro")
public class RegistroController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    JavaBeans usuario = new JavaBeans();
    DAO dao = new DAO();

    public RegistroController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // ...
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("user");
        String senha = request.getParameter("password");
        String email = request.getParameter("email");
        int idade = Integer.parseInt(request.getParameter("idade"));

        JavaBeans usuario = new JavaBeans();
        usuario.setName(name);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setIdade(idade);

        dao.inserirUsuario(usuario);

        response.sendRedirect("cadastro/cad.html");
    }
}

