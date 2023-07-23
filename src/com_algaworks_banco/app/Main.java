package com_algaworks_banco.app;

import java.math.BigDecimal;

import com_algaworks_banco.modelo.*;
import com_algaworks_banco.modelo.atm.CaixaEletronico;
import com_algaworks_banco.modelo.excecao.SaldoInsuficienteException;
import com_algaworks_banco.modelo.pagamento.Boleto;
import com_algaworks_banco.modelo.pagamento.Holerite;

public class Main {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("Álvaro Jordão");
        titular1.setDocumento("14486231465"); 
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);
        System.out.println(titular1.getTipo());

        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Roziana Cunha");
        titular2.setDocumento("3124266578"); 

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 222, 333, new BigDecimal("1000"));
        
        try {
            minhaConta.depositar(new BigDecimal("30000"));
            minhaConta.sacar(new BigDecimal("1000"));

            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal("35000"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("30000"), 160, false);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
