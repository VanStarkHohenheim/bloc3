/**
 * Représente un type de prestation vétérinaire (ex : Insémination, Échographie).
 */
public class TypePrestation {

    private String libelle;
    private float  prixForfaitaire;

    public TypePrestation(String libelle, float prixForfaitaire) {
        this.libelle          = libelle;
        this.prixForfaitaire  = prixForfaitaire;
    }

    public String getLibelle()          { return libelle; }
    public float  getPrixForfaitaire()  { return prixForfaitaire; }

    @Override
    public String toString() {
        return libelle + " (" + prixForfaitaire + " €)";
    }
}
