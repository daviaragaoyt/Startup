package model;

public class JavaBeans {

    private String name;
    private String senha; 
    private String email;
    private int idade;

    public JavaBeans() {
        
    }

    public JavaBeans(String name, String senha, String email, int idade) {
        this.name = name;
        this.senha = senha;
        this.email = email;
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
