/**
 * Association entre un type de prestation et le nombre d'actes réalisés
 * lors d'une visite chez un adhérent.
 */
public class PrestationVisite {

    private TypePrestation leTypePrestation;
    private int            nombreActes;

    public PrestationVisite(TypePrestation typePrestation, int nombreActes) {
        this.leTypePrestation = typePrestation;
        this.nombreActes      = nombreActes;
    }

    public TypePrestation getLeTypePrestation() { return leTypePrestation; }
    public int            getNombreActes()      { return nombreActes; }

    /** Montant pour cette ligne : nombre d'actes × prix forfaitaire. */
    public float getMontant() {
        return nombreActes * leTypePrestation.getPrixForfaitaire();
    }
}
