package webcaisse.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import webcaisse.dao.GrcDAO;
import webcaisse.modele.Conso;
import java.time.LocalDate;
import java.util.ArrayList;

public class RechercheController {
    
    @FXML private TextField txtSeuil;
    @FXML private DatePicker dpDateDeb;
    @FXML private DatePicker dpDateFin;
    @FXML private TableView<Conso> tableConsos;
    @FXML private TableColumn<Conso, String> colNom, colPrenom, colMail, colTel;
    @FXML private TableColumn<Conso, Number> colNbVentes;
    @FXML private Label lblStatus;
    
    @FXML
    public void initialize() {
        // Initialisation des colonnes
        colNom.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNom()));
        colPrenom.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getPrenom()));
        colMail.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getMail()));
        colTel.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTel()));
        colNbVentes.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getNbVentes()));
        
        // Dates par défaut (dernier mois)
        dpDateFin.setValue(LocalDate.now());
        dpDateDeb.setValue(LocalDate.now().minusMonths(1));
    }
    
    @FXML
    private void handleRechercher() {
        try {
            // Validation des entrées
            int seuil = Integer.parseInt(txtSeuil.getText());
            LocalDate dateDeb = dpDateDeb.getValue();
            LocalDate dateFin = dpDateFin.getValue();
            
            if (dateDeb.isAfter(dateFin)) {
                lblStatus.setText("Erreur : Date début > Date fin");
                return;
            }
            
            // Appel DAO sécurisé (OWASP compliant)
            ArrayList<Conso> resultats = GrcDAO.listeConsoAFideliser(seuil, dateDeb, dateFin);
            
            // Mise à jour de la table
            tableConsos.getItems().clear();
            tableConsos.getItems().addAll(resultats);
            
            lblStatus.setText(resultats.size() + " consommateur(s) trouvé(s)");
            
        } catch (NumberFormatException e) {
            lblStatus.setText("Erreur : Le seuil doit être un nombre entier");
        } catch (Exception e) {
            lblStatus.setText("Erreur : " + e.getMessage());
        }
    }
}