package com_algaworks_banco.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String documento;
    private BigDecimal rendimentoAnual;
    private TipoPessoa tipo = TipoPessoa.FISICA;
    private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();


    public Pessoa() {
    }
    
    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;

    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }    


    public BigDecimal getRendimentoAnual() {
        return this.rendimentoAnual;
    }

    public void setRendimentoAnual(BigDecimal rendimentoAnual) {
        this.rendimentoAnual = rendimentoAnual;
    }


    public TipoPessoa getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return this.dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", documento='" + getDocumento() + "'" +
            ", tipo='" + getTipo() + "'" + 
            "}";
    } 

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Pessoa pessoa = (Pessoa) obj;
        return documento.equals(pessoa.documento);
    }

    @Override
    public int hashCode() {
        return 1;
    }

}
