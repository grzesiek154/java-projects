import java.sql.*;


public class JDBC_connector {

    private static final String url = "jdbc:mysql://localhost:3306/trainings_notebook?useSSL=false";
    private static final String user = "admin";
    private static final String password = "admin";



     public static void getConnection() {

         String query = "SELECT VERSION()";
         try {
             Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query);

             while (rs.next()) {
                 System.out.println(rs.getString("name"));
             }
         } catch (SQLException throwable) {
             throwable.printStackTrace();
         }
     }
}
