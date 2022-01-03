package TestCases;

import Constant.Constant;
import PageObjects.BookTicket;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14 extends TestBase{
    @Test(description = "TC10 - User can book 1 ticket at a time")
    public void TC14(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicket bookTicket = new BookTicket();

        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Login" tab
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        //3. Click on "Book ticket" tab
        loginPage.gotoBookticket();

        //4. Select a "Depart date" from the list
        //5. Select "Sài Gòn" for "Depart from" and "Nha Trang" for "Arrive at".
        bookTicket.BookTicket("1/8/2022","Sài Gòn","Nha Trang","Hard seat","1");

        String actualMsg = bookTicket.getBookticketMsg();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg,"Message 'Ticket booked successfully!' displays.");

    }
}
