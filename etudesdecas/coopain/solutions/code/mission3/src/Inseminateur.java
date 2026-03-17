/**
 * Représente un inséminateur (technicien de Coopain).
 * Note sécurité (Q2.4) : aucun mot de passe en clair n'est stocké ici.
 * L'authentification doit passer par un token JWT ou un hash Argon2.
 */
public class Inseminateur {

    private String nom;
    private String prenom;
    private String telephone;

    public Inseminateur(String nom, String prenom, String telephone) {
        this.nom       = nom;
        this.prenom    = prenom;
        this.telephone = telephone;
    }

    public String getNom()       { return nom; }
    public String getPrenom()    { return prenom; }
    public String getTelephone() { return telephone; }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
}
