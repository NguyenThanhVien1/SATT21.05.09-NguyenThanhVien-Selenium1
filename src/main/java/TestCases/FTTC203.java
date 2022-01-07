package TestCases;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import PageObjects.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC203 {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicket bookTicket = new BookTicket();
    RegisterPage registerPage = new RegisterPage();
    MyTicket myTicket = new MyTicket();

    @Test(description = "Error displays when user applies filter with invalid format for\n" +
            "\"Depart Date\" in \"Manage ticket\" table", dataProvider = "data-provider")
    public void FTTC203( String departStation, String arriveStation, String seatType, String ticketAmount,String error,
                         String departStation2,String arriveStation2,String seatType2,String ticketAmount2,
                         String departStation3, String arriveStation3, String seatType3, String ticketAmount3,
                         String departStation4, String arriveStation4, String seatType4, String ticketAmount4,
                         String departStation6, String arriveStation6, String seatType6, String ticketAmount6) {

        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegister();
        registerPage.Register(registerPage.randomEmail(), Constant.PASSWORD, registerPage.randomPID(), Constant.PASSWORD);

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        loginPage.gotoLoginPage();
        loginPage.login(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Book 6 ticket");
        loginPage.gotoBookticket();
        bookTicket.getArriveAt(arriveStation);
        bookTicket.getDepartFrom(departStation);
        bookTicket.getSeatType(seatType);
        bookTicket.getTicketAmount(ticketAmount);
        bookTicket.clickBtnBookTicket();

        loginPage.gotoBookticket();
        bookTicket.getArriveAt(arriveStation2);
        bookTicket.getDepartFrom(departStation2);
        bookTicket.getSeatType(seatType2);
        bookTicket.getTicketAmount(ticketAmount2);
        bookTicket.clickBtnBookTicket();

        loginPage.gotoBookticket();
        bookTicket.getArriveAt(arriveStation3);
        bookTicket.getDepartFrom(departStation3);
        bookTicket.getSeatType(seatType3);
        bookTicket.getTicketAmount(ticketAmount3);
        bookTicket.clickBtnBookTicket();

        loginPage.gotoBookticket();
        bookTicket.getArriveAt(arriveStation4);
        bookTicket.getDepartFrom(departStation4);
        bookTicket.getSeatType(seatType4);
        bookTicket.getTicketAmount(ticketAmount4);
        bookTicket.clickBtnBookTicket();

        loginPage.gotoBookticket();
        bookTicket.getArriveAt(arriveStation6);
        bookTicket.getDepartFrom(departStation6);
        bookTicket.getSeatType(seatType6);
        bookTicket.getTicketAmount(ticketAmount6);
        bookTicket.clickBtnBookTicket();

        System.out.println("4. Click on 'My ticket' tab");
        bookTicket.gotoMyTicket();

        System.out.println("5. Enter invalid date into 'Depart Date'");
        myTicket.gettxtDepartDate();
        System.out.println("6. Click 'Apply filter' button");
        bookTicket.clickCbbArriveStation();
        String actualMsg1 = myTicket.getErrorMessage();
        String expectedMsg1 = error;
        Assert.assertEquals(actualMsg1, expectedMsg1, "Message 'The date format is wrong, date filter is ignored. Example of a '" +
                "proper date: Today is <mm/dd/yyyy>'");

    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        JsonObject jsonObject = JsonHelper.getJsonObject(Utilities.jsonProjectPath());
        JsonObject dataTC14 = jsonObject.getAsJsonObject("FTC2");
        String error = dataTC14.get("error").getAsString();
        String departStation = dataTC14.get("Depart from").getAsString();
        String arriveStation = dataTC14.get("Arrive at").getAsString();
        String seatType = dataTC14.get("Seat type").getAsString();
        String ticketAmount = dataTC14.get("Ticket amount").getAsString();

        String departStation2 = dataTC14.get("Depart from").getAsString();
        String arriveStation2 = dataTC14.get("Arrive at2").getAsString();
        String seatType2 = dataTC14.get("Seat type").getAsString();
        String ticketAmount2 = dataTC14.get("Ticket amount").getAsString();

        String departStation3 = dataTC14.get("Depart from").getAsString();
        String arriveStation3 = dataTC14.get("Arrive at3").getAsString();
        String seatType3 = dataTC14.get("Seat type").getAsString();
        String ticketAmount3 = dataTC14.get("Ticket amount").getAsString();

        String departStation4 = dataTC14.get("Depart from").getAsString();
        String arriveStation4 = dataTC14.get("Arrive at4").getAsString();
        String seatType4 = dataTC14.get("Seat type").getAsString();
        String ticketAmount4 = dataTC14.get("Ticket amount").getAsString();

        String departStation5 = dataTC14.get("Depart from").getAsString();
        String arriveStation5 = dataTC14.get("Arrive at5").getAsString();
        String seatType5 = dataTC14.get("Seat type").getAsString();
        String ticketAmount5 = dataTC14.get("Ticket amount").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount,error,
                        departStation2,arriveStation2,seatType2,ticketAmount2,
                        departStation3,arriveStation3,seatType3,ticketAmount3,
                        departStation4,arriveStation4,seatType4,ticketAmount4,
                        departStation5,arriveStation5,seatType5,ticketAmount5}
        };
        return object;
    }
}
