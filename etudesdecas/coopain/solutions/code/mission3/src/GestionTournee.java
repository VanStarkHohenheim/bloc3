import java.util.ArrayList;

/**
 * Classe métier pour la gestion d'une tournée.
 * Fournit les calculs de chiffre d'affaires et la liste des adhérents visités.
 */
public class GestionTournee {

    private Tournee laTournee;

    public GestionTournee(Tournee tournee) {
        this.laTournee = tournee;
    }

    /** Délègue l'ajout de visite à la tournée. */
    public void ajouterVisite(Visite v) {
        laTournee.ajouterVisite(v);
    }

    // ----------------------------------------------------------------
    // Question 3.1.1 / 3.1.4 : Surcharge – CA toutes prestations
    // ----------------------------------------------------------------
    public float CATournee() {
        float total = 0;
        for (Visite v : laTournee.getLesVisites()) {
            total += v.montantAFacturer();
        }
        return total;
    }

    // ----------------------------------------------------------------
    // Question 3.1.1 : Surcharge – CA pour un type de prestation donné
    // ----------------------------------------------------------------
    public float CATournee(TypePrestation unTypePrestation) {
        float total = 0;
        for (Visite v : laTournee.getLesVisites()) {
            for (PrestationVisite pv : v.getLesPrestationsVisite()) {
                if (pv.getLeTypePrestation().equals(unTypePrestation)) {
                    total += pv.getNombreActes() * unTypePrestation.getPrixForfaitaire();
                }
            }
        }
        return total;
    }

    // ----------------------------------------------------------------
    // Question 3.1.3 : Liste des adhérents uniques de la tournée
    // ----------------------------------------------------------------
    public ArrayList<Adherent> getAdherents() {
        ArrayList<Adherent> adherentsUniques = new ArrayList<>();

        for (Visite v : laTournee.getLesVisites()) {
            Adherent adh = v.getLeAdherent();
            if (!adherentsUniques.contains(adh)) {
                adherentsUniques.add(adh);
            }
        }

        return adherentsUniques;
    }

    public Tournee getLaTournee() { return laTournee; }
}
