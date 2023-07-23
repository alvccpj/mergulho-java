package com_algaworks_banco.modelo.pagamento;

import java.math.BigDecimal;

import com_algaworks_banco.modelo.Pessoa;

public class Holerite implements DocumentoPagavel{

    private Pessoa funcionario;
    private BigDecimal valorHora;
    private int quantidadeHoras;
    private boolean pago;


    public Holerite(Pessoa funcionario, BigDecimal valorHora, int quantidadeHoras, boolean pago) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidadeHoras = quantidadeHoras;
        this.pago = pago;
    }

    @Override
    public BigDecimal getValorTotal() {
        return valorHora.multiply(new BigDecimal(quantidadeHoras));
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
