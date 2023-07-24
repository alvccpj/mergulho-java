package com_algaworks_banco.app;

import java.util.Comparator;

import com_algaworks_banco.modelo.Banco;
import com_algaworks_banco.modelo.Conta;

public class Main3 {
    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));

        for (Conta conta : banco.getContas()) {
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
