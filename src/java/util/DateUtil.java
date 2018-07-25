package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    static public final String DATE_PATTERN = "yyyy/MM/dd HH:mm";

    public String dateToStr(Date date) {
        
        String str;
        if (date == null) {
            str = null;
        } else {
            str = new SimpleDateFormat(DATE_PATTERN).format(date);
        }
        return str;
    }

    public Date strToDate(String str) {
        Date date = null;
        try {
            SimpleDateFormat sdFormat = new SimpleDateFormat(DATE_PATTERN);
            date = sdFormat.parse(str);

        } catch (ParseException e) {

        }
        return date;
    }

}
