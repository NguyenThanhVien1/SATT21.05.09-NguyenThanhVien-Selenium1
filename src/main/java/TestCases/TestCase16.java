package TestCases;

import Common.JsonHelper;
import Common.Utilities;
import Constant.Constant;
import PageObjects.BookTicket;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyTicket;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class TestCase16 extends TestBase{
    @Test(description = "TC16- User can cancel a ticket",dataProvider = "data-provider")
    public void TC16(String departStation, String arriveStation, String seatType, String ticketAmount) throws IOException, ParseException, InterruptedException{
        System.out.println("TC16- User can cancel a ticket");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicket bookTicket = new BookTicket();
        MyTicket myTicket = new MyTicket();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Book a ticket");
        loginPage.gotoBookticket();
        bookTicket.getDepartFrom(departStation);
        bookTicket.getArriveAt(arriveStation);
        bookTicket.getSeatType(seatType);
        bookTicket.getTicketAmount(ticketAmount);
        bookTicket.clickBtnBookTicket();

        System.out.println("4. Click on 'My ticket' tab");
        myTicket.gotoMyTicket();

        System.out.println("5. Click on 'Cancel' button of ticket which user want to cancel.");
        System.out.println("6. Click on 'OK' button on Confirmation message 'Are you sure?'");
        myTicket.getCancelBnt("1","Sài Gòn","Nha Trang");
        Assert.assertFalse(myTicket.CancelRemove("1","Sài Gòn","Nha Trang"));

    }
    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath() + "/src/main/java/TestCases/data.json";
        JsonObject jsonpObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC16 = jsonpObject.getAsJsonObject("TC16");
        String departStation = dataTC16.get("Depart from").getAsString();
        String arriveStation = dataTC16.get("Arrive at").getAsString();
        String seatType = dataTC16.get("Seat type").getAsString();
        String ticketAmount = dataTC16.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
