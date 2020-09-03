package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class EntityManagement {



    public static void printData(Connection con, String tableName) {
        Statement st;
        String query = "SELECT * FROM "+ tableName;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void doQuery(Connection con, String query) {
        Statement st;

        try {
            System.out.println(query);
            st = con.createStatement();
            st.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
