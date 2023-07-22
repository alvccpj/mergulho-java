package com_algaworks_banco.modelo.pagamento;

import com_algaworks_banco.modelo.Pessoa;

public class Holerite implements DocumentoPagavel{

    private Pessoa funcionario;
    private double valorHora;
    private int quantidadeHoras;
    private boolean pago;


    public Holerite(Pessoa funcionario, double valorHora, int quantidadeHoras, boolean pago) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidadeHoras = quantidadeHoras;
        this.pago = pago;
    }

    @Override
    public double getValorTotal() {
        return valorHora * quantidadeHoras;
    }

    @Override
    public boolean estaPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }
    
}
