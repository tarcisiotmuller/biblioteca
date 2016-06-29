package br.com.biblioteca.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.model.Livro;
 
@Service("livroService")
@Transactional
public class LivroServiceImpl implements LivroService {
 
    @Autowired
    private LivroDao dao;
     
    public Livro findById(long id) {
        return dao.findById(id);
    }
 
    public void save(Livro livro) {
        dao.save(livro);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void update(Livro livro) {
        Livro entity = dao.findById(livro.getIdlivro());
        if(entity!=null){
            entity.setIdlivro(livro.getIdlivro());
            entity.setNome(livro.getNome());
            entity.setEscritor(livro.getEscritor());
            entity.setAnoedicao(livro.getAnoedicao());
            entity.setClassificacao(livro.getClassificacao());
        }
    }
 
    public void delete(long id) {
        dao.delete(id);
    }
     
    public List<Livro> findAll() {
        return dao.findAll();
    }
      
}