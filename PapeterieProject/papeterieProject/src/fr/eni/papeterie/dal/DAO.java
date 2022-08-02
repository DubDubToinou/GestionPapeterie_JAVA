package fr.eni.papeterie.dal;

import java.util.List;

public interface DAO<T>  {
    
    public T selectById(int id) throws DALException;
    
    public List<T> selectAll() throws DALException;

    public List<T> selectByMarque(String marque) throws DALException;

    public List<T> selectByMotCle(String motCle) throws DALException;

    public void update(T art) throws DALException;

    public void insert(T art) throws DALException;

    public void delete(int idArticle) throws DALException;


}
