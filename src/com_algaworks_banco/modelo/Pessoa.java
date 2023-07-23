package com_algaworks_banco.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pessoa {
    private String nome;
    private String documento;
    private BigDecimal rendimentoAnual;
    private TipoPessoa tipo = TipoPessoa.FISICA;
    private LocalDateTime dataUltimaAtualizacao = LocalDateTime.now();

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

}
