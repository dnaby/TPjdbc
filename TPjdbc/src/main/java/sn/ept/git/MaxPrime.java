package sn.ept.git;

import java.util.Scanner;

public class MaxPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir l'année : ");
        int annee = scanner.nextInt();
        Database db = new Database();
        db.open();
        db.executeRequest("SELECT LIEUTOURNOI, max(PRIME) AS MAX_PRIME FROM GAIN WHERE ANNEE=" + annee + " GROUP BY LIEUTOURNOI");
        db.showResult();
        db.close();
    }
}
