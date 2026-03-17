package coopain.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GestionTourneeTest {

    private Visite v1, v2;
    private TypePrestation tp1, tp2;
    private Tournee t1;
    private GestionTournee gt;

    @BeforeEach
    void setUp() {
        tp1 = new TypePrestation("Insémination", 100);
        tp2 = new TypePrestation("Echographie", 10);
        t1 = new Tournee();
        gt = new GestionTournee(t1);

        v1 = new Visite();
        v1.ajouterPrestationVisite(tp1, 3);
        v1.ajouterPrestationVisite(tp2, 1);

        v2 = new Visite();
        v2.ajouterPrestationVisite(tp1, 1);
    }

    @Test
    void testCATournee() {
        assertEquals(0.0f, gt.CATournee(), "Le CA initial doit être 0");

        gt.ajouterVisite(v1);
        assertEquals(310.0f, gt.CATournee(), "Erreur après la 1ère visite");

        gt.ajouterVisite(v2);
        assertEquals(410.0f, gt.CATournee(), "Erreur sur le CA final de la tournée");
    }

    @Test
    void testAjoutZeroActe() {
        Visite visiteZero = new Visite();

        visiteZero.ajouterPrestationVisite(tp2, 0);

        gt.ajouterVisite(visiteZero);

        assertEquals(0.0f, gt.CATournee(), "L'ajout de 0 acte ne doit pas augmenter le CA");
    }
}