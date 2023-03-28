package sn.ept.git;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Generique {
    public static void main(String[] args) {
        Database db = new Database();  // instance bd
        db.open();  // ouverture objet connexion
        db.executeRequest(args[0]);  // execution requete passe en parametre
        db.showResult();  // affichage resultat
        db.endRequest();  // fermeture objet requete
        db.close();  // fermeture objet connexion
    }
}
