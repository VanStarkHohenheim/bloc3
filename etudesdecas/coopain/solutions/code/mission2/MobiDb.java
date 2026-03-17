import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Helper SQLite pour l'application MobiSemin.
 * Gère la création et la mise à jour de la base de données locale Android.
 *
 * Tables :
 *   - inseminateur : les inséminateurs enregistrés
 *   - vehicule     : les véhicules de service
 *   - histoKm      : l'historique des kilométrages par tournée
 */
public class MobiDb extends SQLiteOpenHelper {

    private static final String DB_NAME    = "mobidb";
    private static final int    DB_VERSION = 1;

    public MobiDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // ----------------------------------------------------------------
    // Question 2.2 : Création des tables
    // ----------------------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Table inseminateur
        String strReq = "CREATE TABLE inseminateur(" +
                "id      INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nom     TEXT NOT NULL, " +
                "prenom  TEXT NOT NULL)";
        db.execSQL(strReq);

        // Table vehicule
        strReq = "CREATE TABLE vehicule(" +
                "id        INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "immat     TEXT NOT NULL, " +
                "marque    TEXT, " +
                "modele    TEXT, " +
                "dateAchat TEXT)";
        db.execSQL(strReq);

        // Table histoKm – liaison entre inséminateur, véhicule et tournée
        strReq = "CREATE TABLE histoKm(" +
                "id          INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date        TEXT    NOT NULL, " +
                "kmDebut     INTEGER NOT NULL, " +
                "kmFin       INTEGER NOT NULL, " +
                "idInsemin   INTEGER NOT NULL, " +
                "idVehicule  INTEGER NOT NULL, " +
                "FOREIGN KEY(idInsemin)  REFERENCES inseminateur(id), " +
                "FOREIGN KEY(idVehicule) REFERENCES vehicule(id))";
        db.execSQL(strReq);
    }

    // ----------------------------------------------------------------
    // Mise à jour du schéma (recréation complète pour simplifier)
    // ----------------------------------------------------------------
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS histoKm");
        db.execSQL("DROP TABLE IF EXISTS vehicule");
        db.execSQL("DROP TABLE IF EXISTS inseminateur");
        onCreate(db);
    }
}
