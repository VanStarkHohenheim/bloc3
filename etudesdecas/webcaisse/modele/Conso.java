package webcaisse.modele;

import javafx.beans.property.*;

public class Conso {
    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty mail;
    private final StringProperty tel;
    private final IntegerProperty nbVentes;

    public Conso(String nom, String prenom, String mail, String tel, int nbVentes) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.mail = new SimpleStringProperty(mail);
        this.tel = new SimpleStringProperty(tel);
        this.nbVentes = new SimpleIntegerProperty(nbVentes);
    }

    // Getters pour PropertyValueFactory
    public String getNom() { return nom.get(); }
    public String getPrenom() { return prenom.get(); }
    public String getMail() { return mail.get(); }
    public String getTel() { return tel.get(); }
    public int getNbVentes() { return nbVentes.get(); }
    
    // Property accessors (pour bindings éventuels)
    public StringProperty nomProperty() { return nom; }
    public IntegerProperty nbVentesProperty() { return nbVentes; }
}