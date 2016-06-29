package br.com.biblioteca.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
 
import br.com.biblioteca.model.Emprestimo;
 
@Repository("emprestimoDao")
public class EmprestimoDaoImpl extends AbstractDao<Long, Emprestimo> implements EmprestimoDao {
 
    public Emprestimo findById(long id) {
        return getByKey(id);
    }
 
    public void save(Emprestimo emprestimo) {
        persist(emprestimo);
    }
 
    public void delete(long id) {
        Query query = getSession().createSQLQuery("delete from Emprestimo where idemprestimo = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Emprestimo> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Emprestimo>) criteria.list();
    }
 
    public boolean livroEmprestado(long idlivro) {
        Query query = getSession().createSQLQuery("from Emprestimo where livro.idlivro = :idlivro AND datahoradevolucao IS NULL");
        query.setLong("idlivro", idlivro);
        return query.list().size() > 1;
    }
    
    public int livrosPessoa(long idpessoa, long idlivro) {
        Query query = getSession().createSQLQuery("from Emprestimo where pessoa.idpessoa = :idpessoa AND livro.idlivro = :idlivro AND datahoradevolucao IS NULL");
        query.setLong("idpessoa", idpessoa);
        query.setLong("idlivro", idlivro);
        return query.list().size();
    }
    
}