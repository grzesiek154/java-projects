package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class which allow users for generic access to basic database queries
 *
 */
public class EntityManagement {


    public static void printData(Connection con, String tableName) {
        Statement st;
        String query = "SELECT * FROM " + tableName;

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



    public static boolean getDataById(Connection con, String tableName, int id) {

        Statement st;
        String query = "SELECT * FROM " + tableName + " WHERE ID=" + id;
        boolean isExist = true;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                System.out.println("Workout with id: " + id + " exist");
                isExist = true;
            } else {
                System.out.println("Workout with id: " + id + " do not exist");
                isExist = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isExist;
    }

    public static boolean getDataByName(Connection con, String tableName, String name) {

        Statement st;
        String query = "SELECT * FROM " + tableName + " WHERE name=" + "'" + name + "'";
        boolean isExist = true;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                System.out.println("Workout with name: " + name + " exist");
                isExist = true;
            } else {
                System.out.println("Workout with name: " + name + " do not exist");
                isExist = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isExist;
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
