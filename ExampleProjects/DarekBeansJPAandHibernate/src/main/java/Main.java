import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {



    public static void main(String[] args) {

        Date date = new Date(System.currentTimeMillis());
        List array = new ArrayList();
        String destinations = "destinations string: Radom, Poland->Radom, Poland->Berlin->Frankfurt am Main, Germany->Paris, France->Nice, France->Milan, Milan, Italy->Rome, Rome, Italy";
        String[] destArr = destinations.split("->");
            for(String dest: destArr) {
                System.out.println("dest " + dest);
            }


        Calendar calendar = Calendar.getInstance();
        calendar.set(2020,12,15,11,30);
        Calendar cal = new GregorianCalendar(2020,11,15,11,00);
        Date yesterday = cal.getTime();
        calculateDaysDiff(yesterday, date);
        System.out.println(yesterday);
    }

    static Date addMonths(Date date, int months) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        System.out.println("calendar time: " + calendar.getTime());
        System.out.println("calendar field: " + calendar.get(Calendar.MONTH));

        return calendar.getTime();
    }
    static void formatDouble(double value) throws ParseException {
        DecimalFormat decimalFormat = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.GERMAN));
        String newValue = decimalFormat.format(value);
        double newDouble = decimalFormat.parse(newValue).doubleValue();
        System.out.println(newDouble);
    }
    static LocalDate convertDateToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    static void calculateDaysDiff(Date start, Date end) {

        long dateDiff = Math.abs(end.getTime() - start.getTime());
        long diff = TimeUnit.HOURS.convert(dateDiff, TimeUnit.MILLISECONDS);
        System.out.println("date diff " + diff);
    }
}
