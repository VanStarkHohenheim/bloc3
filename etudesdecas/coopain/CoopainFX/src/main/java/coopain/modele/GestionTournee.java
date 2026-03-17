package coopain.modele;

public class GestionTournee {

    private Tournee laTournee;

    public GestionTournee(Tournee uneTournee) {
        this.laTournee = uneTournee;
    }

    public void ajouterVisite(Visite uneVisite) {
        laTournee.ajouterVisite(uneVisite);
    }

    // Retourne le montant total à facturer pour l'ensemble des visites de la tournée
    public float CATournee() {
        float caTotal = 0;
        for (Visite v : laTournee.getLesVisites()) {
            caTotal += v.montantAFacturer();
        }
        return caTotal;
    }
}
