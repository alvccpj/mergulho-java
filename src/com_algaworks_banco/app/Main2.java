package com_algaworks_banco.app;

import java.util.ArrayList;
import java.util.List;

import com_algaworks_banco.modelo.Pessoa;

public class Main2 {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Álvaro Jordão", "14486231465");
        Pessoa pessoa2 = new Pessoa("Amanda Jordão", "34567898723");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        System.out.println(pessoas.toString());
    }
}
