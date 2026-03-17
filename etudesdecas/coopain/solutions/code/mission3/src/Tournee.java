import java.util.ArrayList;
import java.util.Date;

/**
 * Représente une tournée d'un inséminateur à une date donnée.
 * Contient l'ensemble des visites effectuées.
 */
public class Tournee {

    private Date                date;
    private Inseminateur        leInseminateur;
    private ArrayList<Visite>   lesVisites;

    public Tournee(Date date, Inseminateur inseminateur) {
        this.date            = date;
        this.leInseminateur  = inseminateur;
        this.lesVisites      = new ArrayList<>();
    }

    public void ajouterVisite(Visite v) {
        lesVisites.add(v);
    }

    public Date               getDate()            { return date; }
    public Inseminateur       getLeInseminateur()  { return leInseminateur; }
    public ArrayList<Visite>  getLesVisites()      { return lesVisites; }
}
