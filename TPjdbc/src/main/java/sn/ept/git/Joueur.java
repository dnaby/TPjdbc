package sn.ept.git;

import java.sql.SQLException;

public class Joueur {
    static String requete = "select nom, prenom from Joueur";

    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        db.open();
        db.executeRequest(requete);
        db.endRequest();
        db.showResult();
        db.close();
    }
}
