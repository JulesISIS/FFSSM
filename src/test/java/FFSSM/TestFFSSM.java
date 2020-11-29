package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mjule
 */
public class TestFFSSM {

    private Club c1;
    private Embauche e1;
    private Licence l1, l2, l3;
    private Moniteur m1;
    private Personne p1, p2, p3;
    private Plongee pe1;
    private Plongeur pr1, pr2;
    private Site s1;

    @BeforeEach
    public void setUp() throws Exception {
        c1 = new Club(m1, "Go&Sea", "0102030405");
        e1 = new Embauche(LocalDate.of(2018, 10, 01), m1, c1);
        l1 = new Licence(p1, "0101", LocalDate.of(2018, 10, 02), 5, c1);
        l2 = new Licence(p2, "8706", LocalDate.of(2018, 05, 16), 1, c1);
        l3 = new Licence(p3, "1615", LocalDate.of(2019, 01, 02), 2, c1);
        m1 = new Moniteur("010203", "Montsaint", "Michel", "1 Rue CDG", "0405060708", LocalDate.of(1990, 12, 10), 13);
        p1 = new Personne("010203", "Montsaint", "Michel", "1 Rue CDG", "0405060708", LocalDate.of(1990, 12, 10));
        p2 = new Personne("064723", "Pichon", "Albert", "3 Avenue Pompidou", "0542144878", LocalDate.of(1980, 05, 28));
        p3 = new Personne("564221", "Mas", "Lucie", "560 Route du Tertre", "0106068556", LocalDate.of(1992, 12, 13));
        pe1 = new Plongee(s1, m1, LocalDate.of(2019, 01, 10), 50, 80);
        pr1 = new Plongeur("064723", "Pichon", "Albert", "3 Avenue Pompidou", "0542144878", LocalDate.of(1980, 05, 28), 1);
        pr2 = new Plongeur("264221", "Mas", "Lucie", "560 Route du Tertre", "0106068556", LocalDate.of(1992, 12, 13), 2);
        s1 = new Site("Corse du Sud", "Voyage en avion nécessaire");
    }

    @Test
    public void testOrganisePlongee() {
        c1.organisePlongee(pe1);                                                //On ajoute la plongée à la liste 
        assertEquals(pe1, c1.myPlongees.get(0), "La plongée n'a pas été ajoutée à la liste des plongées organisés");    //On vérifie que la plongée est ajoutée
    }

    @Test
    public void testAjouteParticipant() {
        pe1.ajouteParticipant(l1);                                              //On ajoute un particpant à la plongée
        assertEquals(l1, pe1.myParticipants.get(0), "Le plongeur n'a pas été ajouté à la liste des participants de la plongée"); //On vérifie que le participant est ajouté
    }

    @Test
    public void testEstValide() {
        assertFalse(l1.estValide(LocalDate.now()), "La licence n'est pas valide");  //On teste si la licence d'un plongeur est valide
    }

    @Test
    public void testEstConforme() {
        pe1.ajouteParticipant(l2);                                              //On ajoute deux participants à une plongée
        pe1.ajouteParticipant(l3);
        assertTrue(pe1.estConforme(), "La plongée est conforme car les deux licences sont valides");    //On vérifie que la plongée est conforme
    }
    
    @Test
    public void testEmployeurActuel() {
        m1.nouvelleEmbauche(c1, LocalDate.of(2020, 2, 6));                      //On embauche le moniteur m1 via le club c1
        assertEquals(m1.employeurActuel().get(), c1, "L'employeur actuel est le club Go&Sea");   //On teste que le moniteur m1 est bien embauché par le club c1
    }

    @Test
    public void testTerminerEmbauche() {
        e1.terminer(LocalDate.now());                                           //On met fin à une embauche e1
        assertTrue(e1.estTerminee(), "L'embauche e1 doit être terminée");       //On vérifie que la fin de l'embauche est effective
    }
}
