package FFSSM;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne {
    public int niveau;
    public List<Licence> Llicence  = new LinkedList<>();
    
    public Plongeur (String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance,int niv){
         super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        niv=niveau;
    }
    public void ajouteLicence(Licence l){
        if(l==null)
            throw new IllegalArgumentException("La licence est null");
        this.Llicence.add(l);
    }	

    public List<Licence> getLicence() {
        return Llicence;
    }
    
    
}
