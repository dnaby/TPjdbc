package sn.ept.git;

public class Generique2 {
    public static void main(String[] args) {
        Database db = new Database();
        db.open("jdbc:mysql://localhost:3306/sponsor", "anonyme", "anonyme");
        db.executeRequest(args[0]);
        db.endRequest();
        db.close();
    }
}
