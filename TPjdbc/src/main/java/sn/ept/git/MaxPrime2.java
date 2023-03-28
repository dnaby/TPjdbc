package sn.ept.git;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MaxPrime2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PreparedStatement preparedStatement;
        ResultSet result;
        int annee;
        try {
            Database db = new Database();
            db.open();
            preparedStatement = db.getConnexion().prepareStatement(
                    "SELECT LIEUTOURNOI, max(PRIME) AS MAX_PRIME FROM GAIN WHERE ANNEE = ? GROUP BY LIEUTOURNOI"
            );
            while (true) {
                System.out.print("Veuillez saisir l'année (ou appuyez sur Entrée pour quitter) : ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) { break; }
                try {
                    annee = Integer.parseInt(input);
                    preparedStatement.setInt(1, annee);
                    result = preparedStatement.executeQuery();
                    while (result.next()) {
                        String tuple = result.getString("LIEUTOURNOI") + " " + result.getString("MAX_PRIME");
                        System.out.println(tuple);
                    }
                    result.close();
                } catch (NumberFormatException | SQLException e) { e.printStackTrace(); }
            }
            db.close();
        } catch(Exception e) { e.printStackTrace(); }
    }
}
