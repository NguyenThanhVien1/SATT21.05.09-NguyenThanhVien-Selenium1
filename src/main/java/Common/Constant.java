package Common;

import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


public class Constant {
        public static WebDriver WEBDRIVER;
        public static final String RAIlWAY_URL = "http://www.raillog.somee.com/Page/BookTicketPage.cshtml";
        public static final String USERNAME = "vien@gmail.com";
        public static final String PASSWORD = "12345678";
        public static final String CONFIRMPASSWORD = "12345678";
        public static final String INVALIDPASSWORD = "a123:\'/{}!@$\\";
        public static final String INVALIDCONFIRMPASSWORD = "b456:\"/{}!@$\\";
        public static String date;
        public static void getDate(int day){
                Constant.WEBDRIVER.manage().timeouts().implicitlyWait(2, TimeUnit.MILLISECONDS);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate localDate = LocalDate.now().plusDays(day);
                date = formatter.format(localDate);
                if(date.charAt(0) == '0'){
                        date = date.substring(1);
                }
        }
}


