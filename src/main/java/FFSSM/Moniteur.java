/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Personne {

    public int numeroDiplome;
    public List<Embauche> myEmplois = new ArrayList();
    public HashMap<Club, LocalDate> myNewEmbauches = new HashMap<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
        this.myEmplois = new ArrayList();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        Optional<Club> myClubs;
        if (!myEmplois.get(myEmplois.size() - 1).estTerminee()) {
            Club club = myEmplois.get(myEmplois.size() - 1).getEmployeur();
            myClubs = Optional.ofNullable(club);
        } else {
            Club club = null;
            myClubs = Optional.ofNullable(club);
        }
        return myClubs;
    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        Embauche emb = new Embauche(debutNouvelle, this, employeur);
        myEmplois.add(emb);
    }

    public List<Embauche> emplois() {
        return myEmplois;
    }

}
