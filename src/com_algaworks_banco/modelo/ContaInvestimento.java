package com_algaworks_banco.modelo;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Pessoa titular, int agencia, int numero) {
        super(titular, agencia, numero);
    }

    @Override
    public void debitarTarifaMensal() {
        {
            if (getSaldo() < 10000) {
                sacar(30);
            }
        }
    }

    public void creditarRendimentos(double percentualJuros) {
        double valolRendimentos = getSaldo() * percentualJuros / 100;
        depositar(valolRendimentos);
    }
}
