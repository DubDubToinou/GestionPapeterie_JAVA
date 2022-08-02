package fr.eni.papeterie.bo;
/**
 * @author Antoine DUBUC
 * @version 1.0 Papeterie en JAVA.
 */

 
/**
 * 
 */
public abstract class Article {
    
    private Integer idArticle;
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

    public Article(Integer idArticle, String marque, String reference,  String designation, float prixUnitaire,
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
        this(null, marque, reference, designation, prixUnitaire, qteStock);
}


/**
 * L'ensemble des Getter et Setter, sur l'ensemble des attributs.
 * en Public donnant la possibilité de les utiliser dans d'autre classe.
 * 
 */

    public Integer getIdArticle() {
        return this.idArticle;
    }


    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }


    public String getReference() {
        return this.reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }


    public String getMarque() {
        return this.marque;
    }


    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getPrixUnitaire() {
        return this.prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQteStock() {
        return this.qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    @Override
    public String toString() {
        return "Article [ID ARTICLE : " + idArticle + " | REFERENCE : " + reference + " | MARQUE : " + marque
                + " | DESIGNATION : " + designation + " | Prix Unitaire : " + prixUnitaire + " | QTE STOCK : " + qteStock
                + "]";
    }

}
