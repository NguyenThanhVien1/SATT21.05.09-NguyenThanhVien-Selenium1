package TestCases;

import Constant.Constant;
import PageObjects.BookTicket;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4 extends TestBase{


    @Test(description = "TC04 - User is redirected to Book ticket page after logging in ")
    public void TC04(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicket bookTicket = new BookTicket();
        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Book ticket" tab
        loginPage.gotoBookticket();
        //3. Login with valid account
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = bookTicket.getBookticketCenter();
        String expectedMsg = "Book ticket";
        Assert.assertEquals(actualMsg, expectedMsg,"Book ticket page displays with Book ticket form opens");
    }
}
