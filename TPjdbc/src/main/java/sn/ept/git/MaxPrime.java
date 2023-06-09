package sn.ept.git;

import java.util.Scanner;

public class MaxPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir l'année : ");
        int annee = scanner.nextInt();  // recuperation annee
        Database db = new Database();  // instance bd
        db.open();  // ouverture objet connexion
        // execution requete passe en parametre
        db.executeRequest("SELECT LIEUTOURNOI, max(PRIME) AS MAX_PRIME FROM GAIN WHERE ANNEE=" + annee + " GROUP BY LIEUTOURNOI");
        db.showResult();  // affichage resultat
        db.endRequest();  // fermeture objet requete
        db.close();  // fermeture objet connexion
    }
}
