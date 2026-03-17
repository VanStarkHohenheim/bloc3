/**
 * Représente un adhérent (éleveur client de Coopain).
 * Contient ses coordonnées GPS pour le calcul des tournées.
 */
public class Adherent {

    private String nom;
    private String prenom;
    private String telephone;
    private String latitude;
    private String longitude;

    public Adherent(String nom, String prenom, String telephone,
                    String latitude, String longitude) {
        this.nom       = nom;
        this.prenom    = prenom;
        this.telephone = telephone;
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    // ----------------------------------------------------------------
    // Question 3.1.2 : Retourne les coordonnées GPS sous forme "lat lon"
    // ----------------------------------------------------------------
    public String getCoordGPS() {
        return this.latitude + " " + this.longitude;
    }

    public String getNom()       { return nom; }
    public String getPrenom()    { return prenom; }
    public String getTelephone() { return telephone; }
    public String getLatitude()  { return latitude; }
    public String getLongitude() { return longitude; }

    @Override
    public String toString() {
        return prenom + " " + nom + " – GPS : " + getCoordGPS();
    }
}
