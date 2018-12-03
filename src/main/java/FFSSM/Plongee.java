/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;
    
    HashSet<Plongeur> Lplongeurs = new HashSet();

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");	
        if (participant == null)
            throw new IllegalArgumentException("Le participant est null");
        Lplongeurs.add(participant);
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        for (Plongeur p: Lplongeurs){
            
            if(p.getLicence().isEmpty() || !p.getLicence().get(p.getLicence().size()-1).estValide(date))
                return false;
        }
        return !Lplongeurs.isEmpty();
        
    }

}
