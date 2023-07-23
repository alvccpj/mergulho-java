package com_algaworks_banco.modelo.excecao;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException(String message) {
        super(message);
    }
    
}
