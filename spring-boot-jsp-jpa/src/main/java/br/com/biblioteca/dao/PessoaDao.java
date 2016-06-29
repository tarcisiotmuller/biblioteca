package br.com.biblioteca.dao;

import java.util.List;
 
import br.com.biblioteca.model.Pessoa;
 
public interface PessoaDao {
 
    Pessoa findById(long id);
 
    void save(Pessoa pessoa);
     
    void delete(long id);
     
    List<Pessoa> findAll();
 
}