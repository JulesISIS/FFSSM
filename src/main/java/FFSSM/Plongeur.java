package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;

public class Plongeur extends Personne {

    public int niveau;
    public HashSet<Licence> myLicences = new HashSet<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }

    public void ajouteLicence(String numero, LocalDate delivrance, Club c) {
        Licence l = new Licence(this, numero, delivrance, niveau, c);
        myLicences.add(l);
    }
}
