package sn.ept.git;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Schema {
    public static void main(String[] args) {
        try {
            Database db = new Database();
            db.open();
            DatabaseMetaData databaseMetaData = db.getConnexion().getMetaData();
            ResultSet result = databaseMetaData.getColumns("tennis", null, args[0], null);

            ResultSetMetaData metaData = result.getMetaData();

            System.out.println("java schema " + args[0]);
            System.out.println("Le schéma de " + args[0] + " est :");

            // Affichage des noms des attributs
            System.out.printf("%-20s", "NOM");
            System.out.printf("%-20s", "TYPE");
            System.out.println();

            // Affichage de la ligne de pointillés
            for (int i = 1; i <= 2; i++) {
                System.out.print("--------------------");
            }
            System.out.println();

            // Affichage des enregistrements

            while (result.next()) {
                System.out.printf("%-20s", result.getString(result.findColumn("COLUMN_NAME")));
                System.out.printf("%-20s", result.getString(result.findColumn("TYPE_NAME")));
                System.out.println();
            }

            db.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
