package com_algaworks_banco.modelo;

import java.math.BigDecimal;
import java.util.Objects;

import com_algaworks_banco.modelo.excecao.SaldoInsuficienteException;

public abstract class Conta {

    // características
    private Pessoa titular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    //construtor padrão
    Conta () {

    }

    // construtor com argumentos
    public Conta(Pessoa titular, int agencia, int numero) {
        Objects.requireNonNull(titular); //se o objeto for nulo, retorna 'NullPointerException'
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    // método
    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        } else {
            saldo = saldo.add(valor);
        }
    }

    // método
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        } else if (getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        } else {
            saldo = saldo.subtract(valor);
        }
    }

    public void sacar(BigDecimal valor, BigDecimal taxaSaque) {
        sacar(valor.add(taxaSaque));
    }

    public abstract void debitarTarifaMensal();

    //getters e setters
    public Pessoa getTitular() {
        return this.titular;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public BigDecimal getSaldoDisponivel () {
        return getSaldo();
    }
}
