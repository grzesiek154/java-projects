import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Date date1 = new GregorianCalendar(2014, Calendar.FEBRUARY, 11, 12, 00,00).getTime();
        Date date2 = new GregorianCalendar(2014, Calendar.FEBRUARY, 11, 20, 01,00).getTime();

        double doubleDate1 = 1.6160184E12;
        double doubleDate2 = 1.61604726E12;

        System.out.println((doubleDate1 - doubleDate2)/ 1000 / 60 / 60);

    }



    static double getPercentageDiff(double originalVal, double updatedVal) {
        double result = 0;
        result = ((updatedVal-originalVal) * 100)/ originalVal;
        return result;
    }
}
