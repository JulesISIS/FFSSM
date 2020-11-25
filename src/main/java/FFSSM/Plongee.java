/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;

public class Plongee {

    public Site lieu;
    public Moniteur chefDePalanquee;
    public LocalDate date;
    public int profondeur;
    public int duree;
    public HashSet<Licence> myParticipants = new HashSet<>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Licence l) {
        myParticipants.add(l);
    }

    public LocalDate getDate() {
        return date;
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        for (Licence l : myParticipants) {
            if (l.estValide(date)) {
                return true;
            }
        }
        return false;
    }

}
