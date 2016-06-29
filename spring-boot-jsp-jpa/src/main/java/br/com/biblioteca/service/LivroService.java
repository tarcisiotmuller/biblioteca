package br.com.biblioteca.service;

import java.util.List;
 
import br.com.biblioteca.model.Livro;
 
public interface LivroService {
 
    Livro findById(long id);
     
    void save(Livro livro);
     
    void update(Livro livro);
     
    void delete(long id);
 
    List<Livro> findAll(); 
     
}