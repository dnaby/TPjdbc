package sn.ept.git;

import java.sql.*;

public class Database {
    /**
     * Cette classe a ete cree pour gerer relatif à la connexion à la base
     * et aux requetes et affichages de resultat de requetes pour eviter toute
     * repetition dans le code.
     */
    private ResultSet result;
    private Statement lecture;
    private Connection connexion;

    public void open() {
        /**
         * Fonction pour creer l'objet connexion
         */
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver pilote = (Driver) c.newInstance();
            DriverManager.registerDriver(pilote);
            connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tennis",
                    "root",
                    "");
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void open(String url, String user, String password) {
        /**
         * Surcharge fonction pour creer l'objet connexion
         * à partir d'information passées en paramètres
         */
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver pilote = (Driver) c.newInstance();
            DriverManager.registerDriver(pilote);
            connexion = DriverManager.getConnection(url, user, password);
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void close() {
        /**
         * Fonction pour fermer l'objet connexion
         */
        try {
            connexion.close();
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void executeRequest(String request) {
        /**
         * Fonction executer une requete passee en
         * parametre sur l'instance de bd
         */
        try {
            lecture = connexion.createStatement();
            result = lecture.executeQuery(request);
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void endRequest() {
        /**
         * Fonction pour fermer les objets liees à la
         * requete qui vient d'etre executee
         */
        try {
            result.close();
            lecture.close();
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void showResult() {
        /**
         * Fonction pour afficher les resultats
         */
        try {
            ResultSetMetaData metaData = result.getMetaData();
            int columnsNumber = metaData.getColumnCount();

            // Affichage des noms des attributs
            for (int i = 1; i <= columnsNumber; i++) {
                String attributeName = metaData.getColumnName(i);
                System.out.printf("%-20s", attributeName);
            }
            System.out.println();

            // Affichage de la ligne de pointillés
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print("--------------------");
            }
            System.out.println();

            // Affichage des enregistrements
            while (result.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String value = result.getString(i);
                    System.out.printf("%-20s", value);
                }
                System.out.println();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public ResultSet getResult() {
        return result;
    }

    public Connection getConnexion() {
        return connexion;
    }
}
