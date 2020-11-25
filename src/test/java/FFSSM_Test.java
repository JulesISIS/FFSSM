
import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Personne;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

public class FFSSM_Test {

    private Club c1;
    private Embauche e1;
    private Licence l1;
    private Moniteur m1;
    private Personne p1,p2;
    private Plongee pe1;
    private Plongeur pr1;
    private Site s1;

    @BeforeEach
    public void setUp() throws Exception {
        c1 = new Club(m1, "Go&Sea", "0102030405");
        e1 = new Embauche(LocalDate.of(2018, 10, 01), m1, c1);
        l1 = new Licence(p1, "0101", LocalDate.of(2018, 10, 02), 5, c1);
        m1 = new Moniteur("010203", "Montsaint", "Michel", "1 Rue CDG", "0405060708", LocalDate.of(1990, 12, 10), 13);
        p1 = new Personne("010203", "Montsaint", "Michel", "1 Rue CDG", "0405060708", LocalDate.of(1990, 12, 10));
        p2 = new Personne("064723", "Pichon", "Albert", "3 Avenue Pompidou", "0542144878", LocalDate.of(1980, 05, 28));
        pe1 = new Plongee(s1, m1, LocalDate.of(2019, 01, 10), 50, 80);
        pr1 = new Plongeur("064723", "Pichon", "Albert", "3 Avenue Pompidou", "0542144878", LocalDate.of(1980, 05, 28),2);
        s1 = new Site("Golfe d'Arabie","Voyage en avion nécessaire");
    }
    
    public void estValide() throws Exception {
        assertTrue(l1.estValide(LocalDate.of(2018, 12, 25)),"La licence est bien valide");
    }
    
}
