package br.com.biblioteca.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
 
import br.com.biblioteca.model.Pessoa;
 
@Repository("pessoaDao")
public class PessoaDaoImpl extends AbstractDao<Long, Pessoa> implements PessoaDao {
 
    public Pessoa findById(long id) {
        return getByKey(id);
    }
 
    public void save(Pessoa pessoa) {
        persist(pessoa);
    }
 
    public void delete(long id) {
        Query query = getSession().createSQLQuery("delete from Pessoa where idpessoa = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Pessoa> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Pessoa>) criteria.list();
    }
 
}