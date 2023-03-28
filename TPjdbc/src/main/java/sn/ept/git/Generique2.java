package sn.ept.git;

public class Generique2 {
    public static void main(String[] args) {
        Database db = new Database();  // instance bd
        db.open("jdbc:mysql://localhost:3307/sponsor", "anonyme", "anonyme");  // connexion a la bd
        db.executeRequest(args[0]);  // execution requete
        db.endRequest();  // fin requete (fermeture des objets liees a la requete)
        db.close();  // fermeture connexion
    }
}
