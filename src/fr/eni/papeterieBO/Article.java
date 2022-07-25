package fr.eni.papeterieBO;
/**
 * @author Antoine DUBUC
 * @version 1.0 Papeterie en JAVA.
 */

 
/**
 * 
 */
public abstract class Article {
    
    private int idArticle;
    private String reference;
    private String marque;
    private String designation;
    private float prixUnitaire;
    private int qteStock;


/**
 * Constructeur Article ne prenant aucun attribut en paramétres
 */
    
public Article() {
    }

/**
 * Class prenant en paramétre l'ensemble des attributs.
 * @param idArticle
 * @param marque
 * @param reference
 * @param designation
 * @param prixUnitaire
 * @param qteStock
 */

    public Article(int idArticle, String marque, String reference,  String designation, float prixUnitaire,
            int qteStock) {
        this.idArticle = idArticle;
        this.reference = reference;
        this.marque = marque;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.qteStock = qteStock;
    }

/**
 *  Constructeur ne prenant pas en paramétre l'id de l'article.
 * @param marque
 * @param reference
 * @param designation
 * @param prixUnitaire
 * @param qteStock
 */

    public Article(String marque, String reference, String designation, float prixUnitaire, int qteStock) {
        this.reference = reference;
        this.marque = marque;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.qteStock = qteStock;
    }


/**
 * L'ensemble des Getter et Setter, sur l'ensemble des attributs.
 * en Public donnant la possibilité de les utiliser dans d'autre classe.
 * 
 */

    public int getIdArticle() {
        return idArticle;
    }


    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }


    public String getReference() {
        return reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }


    public String getMarque() {
        return marque;
    }


    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    @Override
    public String toString() {
        return "Article [designation=" + designation + ", idArticle=" + idArticle + ", marque=" + marque
                + ", prixUnitaire=" + prixUnitaire + ", qteStock=" + qteStock + ", reference=" + reference + "]";
    }
    

}
