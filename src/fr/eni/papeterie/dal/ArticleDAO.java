package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;

public interface ArticleDAO  {
    
    public Article selectById(int id) throws DALException;
    
    public List<Article> selectAll() throws DALException;

    public void update(Article art) throws DALException;

    public void insert(Article art) throws DALException;

    public void delete(int idArticle) throws DALException;

}
