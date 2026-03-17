package coopain.modele;

import java.util.ArrayList;

public class Visite {

    private ArrayList<PrestationVisite> lesPrestationsVisite = new ArrayList<>();

    public void ajouterPrestationVisite(TypePrestation unTypePrestation, int unNombreActes) {
        lesPrestationsVisite.add(new PrestationVisite(unTypePrestation, unNombreActes));
    }

    public ArrayList<PrestationVisite> getLesPrestationsVisite() { return lesPrestationsVisite; }

    // Réponse Question 3.1.4 : montant total à facturer pour la visite
    public float montantAFacturer() {
        float total = 0;
        for (PrestationVisite pv : lesPrestationsVisite) {
            total += pv.getNombreActes() * pv.getLeTypePrestation().getPrixForfaitaire();
        }
        return total;
    }
}
