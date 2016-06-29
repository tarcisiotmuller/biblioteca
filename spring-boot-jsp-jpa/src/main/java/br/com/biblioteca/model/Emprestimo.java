package br.com.biblioteca.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table
public class Emprestimo implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idemprestimo;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataemprestimo;

    @ManyToOne
    @JoinColumn(name = "idpessoa", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "idlivro", nullable = false)
    private Livro livro;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date datahoradevolucao;

    public long getIdemprestimo() {
        return idemprestimo;
    }

    public void setIdemprestimo(long idemprestimo) {
        this.idemprestimo = idemprestimo;
    }

    public Date getDataemprestimo() {
        return dataemprestimo;
    }

    public void setDataemprestimo(Date dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDatahoradevolucao() {
        return datahoradevolucao;
    }

    public void setDatahoradevolucao(Date datahoradevolucao) {
        this.datahoradevolucao = datahoradevolucao;
    }
  
}