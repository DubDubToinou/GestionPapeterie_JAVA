package fr.eni.papeterieBO;

import java.util.ArrayList;
import java.util.List;

public class Panier {

    List<Ligne> ListeLignesPanier;

    private float montant;

    public Panier() {
        ListeLignesPanier = new ArrayList<Ligne>();
    };

    public float getMontant() {
        return montant;
    }

    
    public final Ligne getLigne(int index) {
        return ListeLignesPanier.get(index);
    }
    
    public List<Ligne> getListeLignesPanier() {
        return ListeLignesPanier;
    }

    public void addLigne(Article article, int qte){
        Ligne ligneAAjouter = new Ligne(article, qte);
        ListeLignesPanier.add(ligneAAjouter);
    }

    public void updateLigne(int index, int newQte){
        this.getLigne(index).setQte(newQte);
    }

    public  void removeLigne(int index){
        ListeLignesPanier.remove(index);
    }

    @Override
    public String toString() {
       
        return super.toString();
    }

}
