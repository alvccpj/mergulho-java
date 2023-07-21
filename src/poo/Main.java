package poo;

import poo.Conta;
import poo.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("Álvaro Jordão");
        titular1.setDocumento("14486231465"); 

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Roziana Cunha");
        titular2.setDocumento("3124266578"); 

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 777, 69);
        ContaEspecial suaConta = new ContaEspecial(titular2, 666, 32, 1000);
        
        minhaConta.depositar(9000);
        minhaConta.sacar(500);
        minhaConta.creditarRendimentos(0.8);
        minhaConta.debitarTarifaMensal();

        suaConta.depositar(8000);
        suaConta.sacar(500);
        suaConta.debitarTarifaMensal();

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
