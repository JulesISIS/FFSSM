package FFSSM;

import java.time.LocalDate;
import java.util.HashMap;

public class Plongeur extends Personne {

    public int niveau;
    public HashMap<String, LocalDate> myLicences = new HashMap<>();

    public Plongeur(int niveau) {
        this.niveau = niveau;
    }

    public void ajouteLicence(String numero, LocalDate delivrance) {
        myLicences.put(numero, delivrance);
    }
}
