import java.sql.*;


public class JDBC_connector {


    private static Connection con;
    private static Statement st;
    private String url;
    private String user;
    private String password;

    public JDBC_connector(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static Connection getConnection(String url, String user, String password) {

         try {
             con = DriverManager.getConnection(url, user, password);
         } catch (SQLException throwable) {
             throwable.printStackTrace();
         }
         return con;
     }

     public static void closeConnection() {
         try {
             con.close();
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
     }





}
