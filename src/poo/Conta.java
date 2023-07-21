package poo;

import java.util.Objects;

public abstract class Conta {

    // características
    private Pessoa titular;
    private int agencia;
    private int numero;
    private double saldo;

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
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        } else {
            saldo = saldo + valor;
        }
    }

    // método
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        } else if (getSaldoDisponivel() - valor < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        } else {
            saldo = saldo - valor;
        }
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

    public double getSaldo() {
        return this.saldo;
    }

    public double getSaldoDisponivel () {
        return getSaldo();
    }
}
