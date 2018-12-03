/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author racin
 */
public class JUnitTest {
    Plongeur Ghada_pl,Moussa_pl ;
    Moniteur mohamet_mo, kevin_mo ;
    Club pacha;
    Site lieu ;
    Calendar fin,debut,date_valide,date_non_valide;
    Licence l_valide,l_non_valide;
    @Before
    public void setUp() {
        
        Ghada_pl  = new Plongeur("P1", "Mokhtari", "Ghada", "Khleb", "455665456565",Calendar.getInstance(), 1);
        Moussa_pl  = new Plongeur("P2", "NDIAYE", "Moussa", "Khleb", "4554555656565",Calendar.getInstance(), 3);
        
        mohamet_mo = new Moniteur("M1", "KONE", "Mohamet", "Khleb", "4554555656565",Calendar.getInstance(), 3,1);
        kevin_mo = new Moniteur("M2", "Tjague", "Kevin", "yaoundé", "54555656565",Calendar.getInstance(), 2,3);
        
        pacha = new Club(mohamet_mo, "Pacha", "64545456554");
        
        debut = Calendar.getInstance();
        debut.set(2018, 11, 20);
        
        lieu = new Site("Castres", "Blabla");
        
        fin = Calendar.getInstance();
        
        fin.set(2018,10, 20);
        
        date_valide= Calendar.getInstance();
        date_valide.set(2017,11,10);
        date_non_valide= Calendar.getInstance();
        date_non_valide.set(2017,10,15);

        l_valide = new Licence(Moussa_pl,"L1",date_valide,2,pacha);
        l_non_valide = new Licence(Moussa_pl,"L1",date_non_valide,2,pacha);
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
        @Test
        public void testLicenceValide(){
            assertFalse(l_non_valide.estValide(Calendar.getInstance()));
        }
    
    	@Test
	public void testPlongeeConforme() {
            
            Plongee plongee = new Plongee(lieu, kevin_mo , Calendar.getInstance(), 10, 2);
            plongee.ajouteParticipant(Ghada_pl);
            plongee.ajouteParticipant(Moussa_pl);
            
            // Licences Valides
            Ghada_pl.ajouteLicence(l_valide);
            Moussa_pl.ajouteLicence(l_valide);

            assertTrue(plongee.estConforme());
            
            //Un des plongeurs a une licence non valide
            Ghada_pl.ajouteLicence(l_non_valide);
            Moussa_pl.ajouteLicence(l_non_valide);
            
            assertFalse(plongee.estConforme());
	}
        
        
        @Test
        public void testEmbauche() {
        kevin_mo.nouvelleEmbauche(pacha, debut);
        assertEquals(pacha, kevin_mo.employeur());
        kevin_mo.emplois().get(kevin_mo.emplois().size()-1).terminer(fin);
        assertEquals(null, kevin_mo.employeur());
	}
            
        @Test
        public void testClub() {
        
        Plongee plongee = new Plongee(lieu, kevin_mo , Calendar.getInstance(), 10, 2);
        plongee.ajouteParticipant(Ghada_pl);
        plongee.ajouteParticipant(Moussa_pl);
        
        Ghada_pl.ajouteLicence(l_valide);
        Moussa_pl.ajouteLicence(l_non_valide);
        pacha.organisePlongee(plongee);
       
        assertTrue(pacha.plongeesNonConformes().contains(plongee));
        
	}
}
