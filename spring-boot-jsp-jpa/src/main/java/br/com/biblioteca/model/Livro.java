package br.com.biblioteca.model;

import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
 
@Entity
@Table
public class Livro implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idlivro;
 
    @Size(min=1, max=100)
    @Column(nullable = false)
    private String nome;
 
    @Column
    private String escritor;
 
    @Column
    private int anoedicao;

    @Column(nullable = false)
    private int classificacao;

    public long getIdlivro() {
        return idlivro;
    }

    public void setIdlivro(long idlivro) {
        this.idlivro = idlivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public int getAnoedicao() {
        return anoedicao;
    }

    public void setAnoedicao(int anoedicao) {
        this.anoedicao = anoedicao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
     
}