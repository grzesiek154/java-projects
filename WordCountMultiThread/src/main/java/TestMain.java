import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TestMain {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormatterTemp = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
        formatSymbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("0.00", formatSymbols);
        DecimalFormat decimalFormat2 = new DecimalFormat("0.00########", formatSymbols);
        String exchangeRate = decimalFormat2.format(28564.02 * 0.31042770086364474);

        System.out.println(exchangeRate);
    
//        Date fromDate = dateFormatter.parse("10.11.2021");
//        Date toDate = dateFormatter.parse("20.11.2021");
//        long diff = toDate.getTime() - fromDate.getTime();
//        System.out.println(diff / (60*60*24*1000));
//        System.out.println(dateFormatter.format(dateFormatterTemp.parse("10/11/2021")));

    }
}
