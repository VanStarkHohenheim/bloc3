package coopain.controleur;

import coopain.modele.*;
import coopain.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.hibernate.Session;
import java.util.List;

public class TourneeController {

    @FXML private ComboBox<TypePrestation> comboPrestations;
    @FXML private TextField txtNbActes;
    @FXML private Label lblTotal;
    @FXML private Label lblMessage;
    @FXML private TextArea txtHistorique;

    private GestionTournee gestionTournee;
    private Visite visiteCourante;

    @FXML
    public void initialize() {
        gestionTournee = new GestionTournee(new Tournee());
        visiteCourante = new Visite();
        gestionTournee.ajouterVisite(visiteCourante);

        // Chargement des TypePrestation depuis MySQL via Hibernate
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<TypePrestation> liste = session.createQuery("from TypePrestation", TypePrestation.class).list();
            session.close();
            comboPrestations.setItems(FXCollections.observableArrayList(liste));
            if (!liste.isEmpty()) comboPrestations.getSelectionModel().selectFirst();
        } catch (Throwable e) {
            lblMessage.setText("Erreur BDD : MySQL inaccessible. Vérifiez XAMPP.");
            System.err.println("Erreur Hibernate : " + e);
        }
    }

    @FXML
    public void handleAjouterActe() {
        lblMessage.setText("");
        try {
            int nbActes = Integer.parseInt(txtNbActes.getText());
            TypePrestation typeSelectionne = comboPrestations.getValue();

            if (typeSelectionne != null && nbActes > 0) {
                visiteCourante.ajouterPrestationVisite(typeSelectionne, nbActes);
                lblTotal.setText("CA Total de la tournée : " + gestionTournee.CATournee() + " €");
                txtHistorique.appendText("- " + nbActes + "x " + typeSelectionne.getLibelle() + "\n");
            } else {
                lblMessage.setText("Veuillez saisir des données valides.");
            }
        } catch (NumberFormatException ex) {
            lblMessage.setText("Le nombre d'actes doit être un entier.");
        }
    }

    @FXML
    public void handleNouvelleTournee() {
        gestionTournee = new GestionTournee(new Tournee());
        visiteCourante = new Visite();
        gestionTournee.ajouterVisite(visiteCourante);

        lblTotal.setText("CA Total de la tournée : 0.0 €");
        txtHistorique.clear();
        lblMessage.setText("");
        txtNbActes.setText("1");
    }
}
