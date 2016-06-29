package br.com.biblioteca.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import br.com.biblioteca.model.Livro;
 
@Repository("livroDao")
public class LivroDaoImpl extends AbstractDao<Long, Livro> implements LivroDao {
 
    public Livro findById(long id) {
        return getByKey(id);
    }
 
    public void save(Livro livro) {
        persist(livro);
    }
 
    public void delete(Long id) {
        Query query = getSession().createSQLQuery("delete from Livro where idlivro = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Livro> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Livro>) criteria.list();
    }
 
}