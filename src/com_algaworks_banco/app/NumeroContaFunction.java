package com_algaworks_banco.app;

import java.util.function.ToIntFunction;

import com_algaworks_banco.modelo.Conta;

public class NumeroContaFunction implements ToIntFunction<Conta>{

    @Override
    public int applyAsInt (Conta conta) {
        return conta.getNumero();
    }
}
