package sn.ept.git;

import java.sql.*;

public class Database {
    private ResultSet result;
    private Statement lecture;
    private Connection connexion;

    public void open() {
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
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver pilote = (Driver) c.newInstance();
            DriverManager.registerDriver(pilote);
            connexion = DriverManager.getConnection(url, user, password);
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void close() {
        try {
            connexion.close();
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void executeRequest(String request) {
        try {
            lecture = connexion.createStatement();
            result = lecture.executeQuery(request);
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void endRequest() {
        try {
            result.close();
            lecture.close();
        } catch(Exception e) { e.printStackTrace(); }
    }

    public void showResult() {
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
