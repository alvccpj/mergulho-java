package com_algaworks_banco.app;

import java.math.BigDecimal;

import com_algaworks_banco.modelo.Banco;
import com_algaworks_banco.modelo.Conta;

public class Main5 {
    public static void main(String[] args) {
        Banco banco = new Banco();

//        Optional<Conta> contaOptional = banco.buscar(123, 222);

//        banco.buscar(123, 222)
//                .ifPresent(conta -> System.out.println(conta.getSaldo()));

//        if (contaOptional.isPresent()) {
//            Conta contaEncontrada = contaOptional.get();
//            System.out.println(contaEncontrada.getSaldo());
//        }

//        Conta contaEncontrada = banco.buscar(123, 333)
//                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
//
//        System.out.println(contaEncontrada.getSaldo());

        BigDecimal saldo = banco.buscar(123, 333)
                .map(Conta::getSaldo)
                .orElse(BigDecimal.ZERO);

        System.out.println(saldo);
    }

}

