package com.example.trabprat.model;
import java.util.ArrayList;

public final class Sistema {
    public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public static void addFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static void removeFuncionario(String nome) {
        for (int i = 0; i < Sistema.funcionarios.size(); i++) {
            if (Sistema.funcionarios.get(i).getNome() == nome) {
                Sistema.funcionarios.remove(i);
            }
        }
    }

    public static void removeFuncionario(int id) {
        for (int i = 0; i < Sistema.funcionarios.size(); i++) {
            if (Sistema.funcionarios.get(i).getId() == id) {
                Sistema.funcionarios.remove(i);
            }
        }
    }
} 
