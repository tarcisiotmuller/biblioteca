package br.com.biblioteca.dao;

import java.util.List;
 
import br.com.biblioteca.model.Livro;
 
public interface LivroDao {
 
    Livro findById(long id);
 
    void save(Livro livro);
     
    void delete(Long id);
     
    List<Livro> findAll();
 
}