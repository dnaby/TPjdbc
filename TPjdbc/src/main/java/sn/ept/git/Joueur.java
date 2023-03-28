package sn.ept.git;

import java.sql.SQLException;

public class Joueur {
    static String requete = "select nom, prenom from Joueur";

    public static void main(String[] args) throws SQLException {
        Database db = new Database();  // instance bd
        db.open();  // ouverture objet connexion
        db.executeRequest(requete);  // execution requete passe en parametre
        db.showResult();  // affichage resultat
        db.endRequest();  // fermeture objet requete
        db.close();  // fermeture objet connexion
    }
}
