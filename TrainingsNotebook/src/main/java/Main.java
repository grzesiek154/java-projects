
import entities.Exercise;
import entities.Training;
import entities.Workout;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        final String url = "jdbc:mysql://localhost/trainings_notebook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "admin";

        //JDBC_connector connector = new JDBC_connector(url, user, password);


        Connection con = JDBC_connector.getConnection(url, user, password);
        Workout.insertWorkout(con, new Workout("pajacyki"));
        Workout.deleteWorkout(con,"przysiady");
        Workout.printWorkouts(con);
    }
}
