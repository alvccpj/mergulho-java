package com_algaworks_banco.app;

import com_algaworks_banco.modelo.*;
import com_algaworks_banco.modelo.atm.CaixaEletronico;
import com_algaworks_banco.modelo.pagamento.Boleto;
import com_algaworks_banco.modelo.pagamento.Holerite;

public class Main {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("Álvaro Jordão");
        titular1.setDocumento("14486231465"); 

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Roziana Cunha");
        titular2.setDocumento("3124266578"); 

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 222, 333, 1000);
        
        minhaConta.depositar(30000);
        minhaConta.sacar(1000);
        // minhaConta.creditarRendimentos(0.8);
        // minhaConta.debitarTarifaMensal();

        suaConta.depositar(15000);
        suaConta.sacar(15500);
        suaConta.debitarTarifaMensal();

        Boleto boletoEscola = new Boleto(titular2, 800);
        Holerite salarioFuncionario = new Holerite(titular2, 100, 160, false);

        caixaEletronico.pagar(boletoEscola, minhaConta);
        caixaEletronico.pagar(salarioFuncionario, minhaConta);

        caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

        boletoEscola.imprimirRecibo();
        salarioFuncionario.imprimirRecibo();

        // System.out.println("Boleto pago: " +boletoEscola.estaPago());
        // System.out.println("Salário pago: " +salarioFuncionario.estaPago());

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
