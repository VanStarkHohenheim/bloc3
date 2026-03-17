import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires JUnit 5 pour GestionTournee.
 * Couvre le calcul du chiffre d'affaires (CATournee) et la liste des adhérents.
 */
public class GestionTourneeTest {

    // ----------------------------------------------------------------
    // Fixtures (Question 3.2 – setUp)
    // ----------------------------------------------------------------
    private TypePrestation tp1, tp2;
    private Inseminateur   ins1;
    private Adherent       adh1, adh2;
    private Tournee        t1;
    private GestionTournee gt;
    private Visite         v1, v2;

    @BeforeEach
    public void setUp() throws Exception {
        // Types de prestation
        tp1 = new TypePrestation("Insémination", 100f);
        tp2 = new TypePrestation("Echographie",   10f);

        // Inséminateur
        ins1 = new Inseminateur("Petit", "Ferdinand", "0600000100");

        // Adhérents
        adh1 = new Adherent("Duboeuf",  "Georges",    "0600000020", "48.5331", "7.72");
        adh2 = new Adherent("Cow",      "Marguerite", "0600000003", "48.5833", "7.75");

        // Tournée du 06/05/2020
        t1 = new Tournee(new SimpleDateFormat("dd-MM-yyyy").parse("06-05-2020"), ins1);
        gt = new GestionTournee(t1);

        // Visite 1 : adh1 – 3 inséminations + 1 échographie = 310 €
        v1 = new Visite(adh1, "09:00");
        v1.ajouterPrestationVisite(tp1, 3); // 3 × 100 = 300
        v1.ajouterPrestationVisite(tp2, 1); // 1 ×  10 =  10

        // Visite 2 : adh2 – 1 insémination = 100 €
        v2 = new Visite(adh2, "14:30");
        v2.ajouterPrestationVisite(tp1, 1); // 1 × 100 = 100
    }

    // ----------------------------------------------------------------
    // Question 3.2 : Test principal – CATournee()
    // ----------------------------------------------------------------
    @Test
    public void testCATournee() {
        // CA initial : aucune visite → 0 €
        assertEquals(0f, gt.CATournee(), 0.01f,
                "CA initial doit être 0 car aucune visite n'a été ajoutée");

        // Après v1 : 300 + 10 = 310 €
        gt.ajouterVisite(v1);
        assertEquals(310.0f, gt.CATournee(), 0.01f,
                "CA après v1 doit être 310 €");

        // Après v2 : 310 + 100 = 410 €
        gt.ajouterVisite(v2);
        assertEquals(410.0f, gt.CATournee(), 0.01f,
                "CA final (v1 + v2) doit être 410 €");
    }

    // ----------------------------------------------------------------
    // Test complémentaire – CATournee(TypePrestation)
    // ----------------------------------------------------------------
    @Test
    public void testCATourneeParType() {
        gt.ajouterVisite(v1);
        gt.ajouterVisite(v2);

        // CA inséminations : (3 + 1) × 100 = 400 €
        assertEquals(400.0f, gt.CATournee(tp1), 0.01f,
                "CA inséminations doit être 400 €");

        // CA échographies : 1 × 10 = 10 €
        assertEquals(10.0f, gt.CATournee(tp2), 0.01f,
                "CA échographies doit être 10 €");
    }

    // ----------------------------------------------------------------
    // Test complémentaire – getAdherents() (liste sans doublon)
    // ----------------------------------------------------------------
    @Test
    public void testGetAdherents() {
        gt.ajouterVisite(v1);
        gt.ajouterVisite(v2);

        ArrayList<Adherent> adherents = gt.getAdherents();

        assertEquals(2, adherents.size(),
                "La tournée doit contenir 2 adhérents distincts");
        assertTrue(adherents.contains(adh1), "adh1 doit être dans la liste");
        assertTrue(adherents.contains(adh2), "adh2 doit être dans la liste");
    }

    // ----------------------------------------------------------------
    // Test complémentaire – getCoordGPS() sur Adherent
    // ----------------------------------------------------------------
    @Test
    public void testGetCoordGPS() {
        assertEquals("48.5331 7.72",  adh1.getCoordGPS());
        assertEquals("48.5833 7.75",  adh2.getCoordGPS());
    }
}
