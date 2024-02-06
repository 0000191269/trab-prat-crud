package com.example.trabprat.model;

public class Funcionario {
    private static int c = 0;
    private final int id;
    private String nome;
    private String senha;
    private String email;
    private int idade;
    
    public Funcionario(String nome, String senha, String email, int idade) {
        Funcionario.c++;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.idade = idade;
        this.id = Funcionario.c;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Funcionario [nome=" + nome + ", senha=" + senha + ", email=" + email + ", idade=" + idade + "]";
    }
    
}
