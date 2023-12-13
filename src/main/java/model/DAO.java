package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

	public Connection conectar() {
        Connection con;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://127.0.0.1:3306/startup?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "1234";
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public void inserirUsuario(JavaBeans usuario) {
        String create = "INSERT INTO dados (name, senha, idade) VALUES (?,?,?)";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, usuario.getName());
            pst.setString(2, usuario.getSenha());
            pst.setInt(3, usuario.getIdade());
            pst.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean validarUsuario(String email, String senha) {
        String query = "SELECT * FROM dados WHERE email = ? AND senha = ?";
        try (Connection con = conectar();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, email);
            pst.setString(2, senha);

            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

