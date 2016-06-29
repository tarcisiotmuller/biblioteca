package br.com.biblioteca.dao;

import java.util.List;
 
import br.com.biblioteca.model.Emprestimo;
 
public interface EmprestimoDao {
 
    Emprestimo findById(long id);
 
    void save(Emprestimo emprestimo);
     
    void delete(long id);
     
    List<Emprestimo> findAll();
 
    boolean livroEmprestado(long idlivro);   //true se o livro estiver emprestado com alguém
 
    int livrosPessoa(long idpessoa, long idlivro); //nro de livros emprestados para a pessoa
    
}