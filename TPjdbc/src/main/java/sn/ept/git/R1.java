package sn.ept.git;

public class R1 {
    public static void main(String[] args) {
        Database db1 = new Database();
        db1.open("jdbc:mysql://localhost:3306/tennis", "root", "");

        Database db2 = new Database();
        db2.open("jdbc:mysql://localhost:3307/sponsor", "anonyme", "anonyme");


        String r1 = "SELECT joueur.NOM, joueur.NATIONALITE, sponsor.NOM FROM tennis.JOUEUR joueur "
                + "LEFT JOIN sponsor.SPONSOR sponsor ON sponsor.NATIONALITE = joueur.NATIONALITE "
                + "ORDER BY joueur.NOM";

        db1.executeRequest(r1);
        db1.showResult();
        db1.endRequest();

        db1.close();
        //db2.close();
    }
}
