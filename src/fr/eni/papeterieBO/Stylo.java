package fr.eni.papeterieBO;

public class Stylo extends Article {

    /**
     * Ajout de l'attribut couleur pour la class stylo. extends de article.
     */
    private String couleur;

    /**
     * Constructeur de stylo prenant en paramètre l'ensemble des attributs de
     * article en rajoutant la couleur du stylo.
     * 
     * @param idArticle
     * @param marque
     * @param reference
     * @param designation
     * @param prixUnitaire
     * @param qteStock
     * @param couleur
     */
    public Stylo(int idArticle, String marque, String reference, String designation, float prixUnitaire, int qteStock,
            String couleur) {
        super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
        this.couleur = couleur;
    }

    /**
     * Constructeur ne prenant pas en paramétre l'idArticle.
     * 
     * @param marque
     * @param reference
     * @param designation
     * @param prixUnitaire
     * @param qteStock
     * @param couleur
     */
    public Stylo(String marque, String reference, String designation, float prixUnitaire, int qteStock,
            String couleur) {
        super(marque, reference, designation, prixUnitaire, qteStock);
        this.couleur = couleur;
    }

    //getter et setter de Stylo.

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String toString() {
		 String texte = String.format("%s Stylo [COULEUR : %s]", super.toString(), getCouleur());
		 return texte;
	}

}
