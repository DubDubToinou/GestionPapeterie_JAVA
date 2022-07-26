package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {

    List<Ligne> ListeLignesPanier;

    private float montant;

    public Panier() {
        ListeLignesPanier = new ArrayList<Ligne>();
    };

    public float getMontant() {
        for (Ligne ligne : ListeLignesPanier) {
            this.montant += ligne.getPrix()*ligne.getQte();            
        }
        return this.montant;
    }

    
    public final Ligne getLigne(int index) {
        return this.ListeLignesPanier.get(index);
    }
    
    public List<Ligne> getListeLignesPanier() {
        return this.ListeLignesPanier;
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
       
        StringBuffer affichageCatalogue = new StringBuffer();
        affichageCatalogue.append("Panier : \n\n");
        
        for(Ligne ligne  : ListeLignesPanier){
            if(ligne != null)
            {
                affichageCatalogue.append("Ligne : " + ListeLignesPanier.indexOf(ligne));
                affichageCatalogue.append(ligne.toString() + "\n");
            }else
            break;
        }
        affichageCatalogue.append("\n\n Total du Panier : " + getMontant() + "\n\n");
        

        return affichageCatalogue.toString();
        
    }

}
