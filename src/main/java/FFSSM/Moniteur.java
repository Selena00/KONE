/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    
    //List<Club> mlClub =new LinkedList();
    List<Embauche> Lembauche = new LinkedList();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niv,int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niv);
        this.numeroDiplome = numeroDiplome;
    }
    


    public Club employeur() {
         // TODO: Implémenter cette méthode
        Embauche monEmbauche= Lembauche.get(Lembauche.size()-1);
        if (monEmbauche.estTerminee()){
            return null;
        }
        else{ 
            return monEmbauche.getEmployeur();
        }
    }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");	    
        Embauche e = new Embauche(debutNouvelle, this, employeur);
        Lembauche.add(e);
    }

    public List<Embauche> emplois() {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        return Lembauche;
    }

}
