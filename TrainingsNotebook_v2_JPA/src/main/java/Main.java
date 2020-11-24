import Controllers.*;
import DAO.ExerciseDaoImpl;
import DAO.WorkoutDaoImpl;
import Entities.Exercise;
import Entities.Workout;

import java.util.*;

public class Main {

    public static void main(String[] args) {


    Random random = new Random();

    double threshold;
    double upperBound = 100.0;
    double rand_double = random.nextDouble() * 100;

    System.out.println(rand_double);
    boolean test = false;

//    if(rand_double <= 20) {
//        test = true;
//        System.out.println("value under 20 found :" + rand_double);
//    } else if (rand_double == 2) {
//        test = false;
//        System.out.println("value 2 found");
//
//    }
//
//        System.out.println("test value: " + test);


//    try {
//        threshold = 0;
//
//        if(rand_double <= 20) {
//
//            threshold = 20;
//        } else {
//            threshold = 60;
//
//        }
//        System.out.println("threshold " + threshold);
//    } catch (Exception e) {
//        e.printStackTrace();
//
if(test) {
    System.out.println("works");
} else {
    System.out.println("not works");
}


    }


}
