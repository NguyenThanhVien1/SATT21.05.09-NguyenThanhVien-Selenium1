package TestCases;

import Constant.Constant;
import PageObjects.BookTicket;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase17 extends TestBase{
    @Test(description = "TC17 - User can't book more than 10 tickets")
    public void TC17() {
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

        //4. Book 10 tickets
        //5. Select "Sài Gòn" for "Depart from" and "Nha Trang" for "Arrive at".
        bookTicket.BookTicket("1/8/2022", "Sài Gòn", "Nha Trang", "Hard seat", "1");

        String actualMsg = bookTicket.getBookticketMsg();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "Message 'Ticket booked successfully!' displays.");
    }
}
