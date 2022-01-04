package TestCases;

import Constant.Constant;
import PageObjects.BookTicket;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyTicket;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase16 extends TestBase{
    @Test(description = "TC16- User can book 1 ticket at a time")
    public void TC16(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicket bookTicket = new BookTicket();
        MyTicket myTicket = new MyTicket();

        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Login" tab
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        //3. Book a ticket
        loginPage.gotoBookticket();
        bookTicket.BookTicket("1/9/2022","Sài Gòn","Nha Trang","Hard seat","2");

        //4. Click on "My ticket" tab
        myTicket.gotoMyTicket();

        //5. Click on "Cancel" button of ticket which user want to cancel.
        myTicket.getCancelBnt("1","Sài Gòn","Nha Trang");

        //6. Click on "OK" button on Confirmation message "Are you sure?"
        Assert.assertFalse(myTicket.CancelRemove("1","Sài Gòn","Nha Trang"));

    }
}
