package fr.eni.papeterie.bo;

public class Ramette extends Article {

    /**
     * Déclaration de l'attribut Grammage propre à Ramette.
     */

    private int grammage;

    public Ramette(){
        super();
    };

    /**
     * Constructeur de Ramette prenant l'ensemble des param de la classe Article en parametre.
     * @param idArticle
     * @param marque
     * @param reference
     * @param designation
     * @param prixUnitaire
     * @param qteStock
     * @param grammage
     */
    public Ramette(Integer idArticle, String marque, String reference, String designation, float prixUnitaire, int qteStock,
            int grammage) {
        super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
        this.grammage = grammage;
    }

    /**
     * Constructeur ne prenant pas en paramétre idArticle
     * 
     * @param marque
     * @param reference
     * @param designation
     * @param prixUnitaire
     * @param qteStock
     * @param grammage
     */
    public Ramette(String marque, String reference, String designation, float prixUnitaire, int qteStock,
            int grammage) {
        this(null, marque, reference, designation, prixUnitaire, qteStock, grammage);
    }
   
    //getter et setter
    public int getGrammage() {
        return this.grammage;
    }

    public void setGrammage(int grammage) {
        this.grammage = grammage;
    }
        
    @Override
    public String toString() {
       String affichage = String.format("%s Ramette [GRAMMAGE : %s ]", super.toString(), getGrammage());
       return affichage;
    }
    
}
