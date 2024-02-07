package com.example.trabprat.model;
import java.util.ArrayList;

public final class Sistema {
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public static boolean search;

    public static void addFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static Funcionario getFuncionario(String nome) {
        for (int i = 0; i < Sistema.funcionarios.size(); i++) {
            if (Sistema.funcionarios.get(i).getNome() == nome) {
                return Sistema.funcionarios.get(i);
            }
        }
        return null;
    }

    public static Funcionario getFuncionario(int id) {
        for (int i = 0; i < Sistema.funcionarios.size(); i++) {
            if (Sistema.funcionarios.get(i).getId() == id) {
                return Sistema.funcionarios.get(i);
            }
        }
        return null;
    }
} 
