/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    
    public List<Plongee> Lplongee = new LinkedList<>();

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    public Set<Plongee> plongeesNonConformes() {
         // TODO: Implémenter cette méthode
        Set LplongeeNc = new HashSet();
        for (Plongee object : Lplongee) {
            if (!object.estConforme()) {
                LplongeeNc.add(object);
            }
        }
        
        return LplongeeNc;
    }

    public void organisePlongee(Plongee p) {
         // TODO: Implémenter cette méthode
            if(p==null)
                throw new IllegalArgumentException("La plongée est null");
            Lplongee.add(p);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
