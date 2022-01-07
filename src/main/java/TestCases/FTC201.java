package TestCases;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.BookTicket;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTC201 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicket bookTicket = new BookTicket();
    RegisterPage registerPage = new RegisterPage();
    @Test(description = "FTTC201 - User can book 1 ticket at a time", dataProvider = "data-provider")
    public void FTTC201( String departStation, String arriveStation, String seatType, String ticketAmount) {

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegister();
        registerPage.Register(registerPage.randomEmail(), Constant.PASSWORD, registerPage.randomPID(), Constant.PASSWORD);

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        loginPage.gotoLoginPage();
        loginPage.login(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        loginPage.gotoBookticket();

        System.out.println("4. Select a 'Depart date' from the list");
        bookTicket.getDepartDate();

        System.out.println("5. Select 'Phan Thiết' for 'Depart from' and 'Đà Nẵng' for 'Arrive at'");
        bookTicket.getArriveAt(arriveStation);
        bookTicket.getDepartFrom(departStation);

        System.out.println("6. Select 'Soft bed with air conditioner' for 'Seat type'");
        bookTicket.getSeatType(seatType);

        System.out.println("7. Select '3' for Ticket amount");
        bookTicket.getTicketAmount(ticketAmount);

        System.out.println("8. Click on 'Book ticket' button");
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
    public Object[][] dataProvider() {
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC14 = jsonObject.getAsJsonObject("FTC");
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
