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

public class TestCase17 extends TestBase{
    @Test(description = "TC17 - User can't book more than 10 tickets",dataProvider = "data-provider")
    public void TC17(String departStation, String arriveStation, String seatType, String ticketAmount) throws IOException, ParseException, InterruptedException {
        System.out.println("User can't book more than 10 tickets");
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

        System.out.println("4. Book 10 tickets and 5. Click on 'Book ticket' tab again");
        loginPage.gotoBookticket();
        bookTicket.getDepartFrom(departStation);
        bookTicket.getArriveAt(arriveStation);
        bookTicket.getSeatType(seatType);
        bookTicket.getTicketAmount(ticketAmount);
        bookTicket.clickBtnBookTicket();

        System.out.println("6. Book one more ticket");
        String actualMsg = bookTicket.getBookTicketerror();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message 'There're errors in the form. Please correct the errors and try again.' displays above the form.");

        String actualMsg2 = bookTicket.getlbErrorMSG();
        String expectedMsg2 = "You have booked 10 tickets. You can book no more.";
        Assert.assertEquals(actualMsg2, expectedMsg2,"Error message display");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath() + "/src/main/java/TestCases/data.json";
        JsonObject jsonpObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonpObject.getAsJsonObject("TC17");
        String departStation = dataTC17.get("Depart from").getAsString();
        String arriveStation = dataTC17.get("Arrive at").getAsString();
        String seatType = dataTC17.get("Seat type").getAsString();
        String ticketAmount = dataTC17.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount},
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }


}
