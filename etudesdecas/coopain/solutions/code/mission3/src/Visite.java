import java.util.ArrayList;

/**
 * Représente une visite chez un adhérent dans le cadre d'une tournée.
 * Regroupe toutes les prestations réalisées lors de cette visite.
 */
public class Visite {

    private Adherent                    leAdherent;
    private String                      heure;
    private ArrayList<PrestationVisite> lesPrestationsVisite;

    public Visite(Adherent adherent, String heure) {
        this.leAdherent           = adherent;
        this.heure                = heure;
        this.lesPrestationsVisite = new ArrayList<>();
    }

    /** Ajoute une prestation (type + nombre d'actes) à cette visite. */
    public void ajouterPrestationVisite(TypePrestation tp, int nombre) {
        lesPrestationsVisite.add(new PrestationVisite(tp, nombre));
    }

    // ----------------------------------------------------------------
    // Question 3.1.4 : Calcul du montant à facturer pour cette visite
    // ----------------------------------------------------------------
    public float montantAFacturer() {
        float total = 0;
        for (PrestationVisite pv : lesPrestationsVisite) {
            total += pv.getNombreActes() * pv.getLeTypePrestation().getPrixForfaitaire();
        }
        return total;
    }

    public Adherent                    getLeAdherent()           { return leAdherent; }
    public String                      getHeure()                { return heure; }
    public ArrayList<PrestationVisite> getLesPrestationsVisite() { return lesPrestationsVisite; }
}
