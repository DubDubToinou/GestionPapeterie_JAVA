package fr.eni.papeterie.bll;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.Factory;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.DAO;

public class CatalogueManager {

    private DAO<Article> dao = Factory.getArticleDAO();

    public CatalogueManager() throws BLLException{

    }

    public void addArticle(Article a) throws BLLException{
        if(a.getIdArticle() != null){
            throw new BLLException("Article déjà dans la base");
        }
        try {
                validerArticle(a);
                dao.insert(a);
            
        } catch (DALException ex) {
            throw new BLLException("l'article n'a pas pu être ajouter", ex);
        }
    }

    public void updateArticle(Article a) throws BLLException{

        try {
                validerArticle(a);
                dao.update(a);
            
        } catch (DALException ex) {
            throw new BLLException("L'article n'a pas pu être mit à jour. - article : "+a, ex);
        }

    }

    public void removeArticle(Article a) throws BLLException{
        try {

            dao.delete(a.getIdArticle());
            
        } catch (DALException ex) {
            throw new BLLException("L'article n'a pas pu être supprimé - ", ex);
        }
    }

    public List<Article> getCatalogue() throws BLLException{
        List<Article> articles = null;

        try {

            articles = dao.selectAll();
            
        } catch (DALException ex) {
            ex.printStackTrace();
            throw new BLLException("Erreur, le catalogue n'a pas pu être généré.", ex);
        }

        return articles;

    }

    public void validerArticle(Article a) throws BLLException{

        boolean valide = true;
        StringBuffer sb = new StringBuffer();

        if(a == null){
            throw new BLLException("Article null");
        }

        if(a.getReference() == null || a.getReference().trim().isEmpty()){
            sb.append("Référence obligatoire");
            valide = false;
        }

        if(a.getMarque() == null || a.getMarque().trim().length() == 0){
            sb.append("Marque obligatoire");
            valide = false;
        }

        if(a.getDesignation() == null || a.getDesignation().trim().length() == 0){
            sb.append("Designation d'article obligatoire");
            valide = false;
        }

        if(a instanceof Ramette && ((Ramette)a).getGrammage() <= 0){
            sb.append("Merci de saisir un grammage");
            valide = false;
        }

        if(a instanceof Stylo){
            Stylo s = (Stylo) a;
            if(s.getCouleur() == null || s.getCouleur().trim().length() == 0){
                sb.append("Merci de saisir une couleur au stylo");
                valide = false;
            };
        
        }

        if(!valide){
            throw new BLLException(sb.toString());
        }


    }
}
