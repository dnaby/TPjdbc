package sn.ept.git;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Generique {
    public static void main(String[] args) {
        Database db = new Database();
        db.open();
        db.executeRequest(args[0]);
        db.showResult();
        db.endRequest();
        db.close();
    }
}
