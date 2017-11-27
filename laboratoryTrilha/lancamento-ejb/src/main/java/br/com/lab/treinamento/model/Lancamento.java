package br.com.lab.treinamento.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author furlan
 */
public class Lancamento implements Serializable {

    private String nome = "";
    private String data = "";
    private Double valor = 0D;
    private int tipoLancamento = 0;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(int tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    @Override
    public String toString() {
        return "lancamento{" + "nome=" + nome + ", data=" + data + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.valor);
        hash = 53 * hash + this.tipoLancamento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lancamento other = (Lancamento) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }
}
