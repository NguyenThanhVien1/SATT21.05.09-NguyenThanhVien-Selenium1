package TestCases;

import Common.JsonHelper;
import Common.Utilities;
import Constant.Constant;
import PageObjects.BookTicket;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class TestCase14 extends TestBase{
    @Test(description = "TC14 - User can book many tickets at a time",dataProvider = "data-provider")
    public void TC014(String departStation, String arriveStation, String seatType, String ticketAmount) throws IOException, ParseException, InterruptedException{
        System.out.println("TC14 - User can book many tickets at a time");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicket bookTicket = new BookTicket();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        loginPage.gotoBookticket();

        System.out.println("4. Select a 'Depart date' from the list");
        bookTicket.getDepartFrom(departStation);
        bookTicket.getArriveAt(arriveStation);
        bookTicket.getSeatType(seatType);
        bookTicket.getTicketAmount(ticketAmount);
        bookTicket.clickBtnBookTicket();
        String actualMsg1 = bookTicket.getBookticketMsg();
        String expectedMsg1 = "Ticket Booked Successfully!";
        Assert.assertEquals(actualMsg1, expectedMsg1, "Success msg is not display as expected");

        String actualMsg2 = bookTicket.getResultDepart();
        String expectedMsg2 = departStation;
        Assert.assertEquals(actualMsg2, expectedMsg2, "Depart Station info not correct ");

        String actualMsg3 = bookTicket.getResultArrive();
        String expectedMsg3 = arriveStation;
        Assert.assertEquals(actualMsg3, expectedMsg3, "Arrive Station info not correct ");

        String actualMsg4 = bookTicket.getResultSeat();
        String expectedMsg4 = seatType;
        Assert.assertEquals(actualMsg4, expectedMsg4, "Seat Type info not correct ");

        String actualMsg5 = bookTicket.getResultAmount();
        String expectedMsg5 = ticketAmount;
        Assert.assertEquals(actualMsg5, expectedMsg5, "Ticket Amount info not correct ");
    }
    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath() + "/src/main/java/TestCases/data.json";
        JsonObject jsonpObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonpObject.getAsJsonObject("TC14");
        String departStation = dataTC14.get("Depart from").getAsString();
        String arriveStation = dataTC14.get("Arrive at").getAsString();
        String seatType = dataTC14.get("Seat type").getAsString();
        String ticketAmount = dataTC14.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
