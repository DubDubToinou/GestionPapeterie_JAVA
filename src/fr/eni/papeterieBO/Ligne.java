package fr.eni.papeterieBO;


public class Ligne {
    
    //QTE en protected, utilisable uniquement dans cette classe.
    protected int qte;

    //Ajout d'un atribut Article venant de la class Article.
    protected Article article;

    /**
     * Constructeur d'une Ligne. prenant en paramétre une Quantité et un Article (Ramette / Stylo)
     * @param qte
     * @param article
     */
    public Ligne(Article article, int qte) {
        this.qte = qte;
        this.article = article;
    }

    //Getter / Setter:

    public Article getArticle() {
        return article;
    }

    private void setArticle(Article article){
        this.article = article;                         // Erreur car non utilisé pour le moment.
    };

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrix(){
        return article.getPrixUnitaire();

    }
    
    @Override
    public String toString() {
       
        return super.toString();
    }
   

}
