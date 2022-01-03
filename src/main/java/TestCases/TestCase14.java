package TestCases;

import Constant.Constant;
import PageObjects.BookTicket;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14 extends TestBase{
    @Test(description = "TC14 - User can book many tickets at a time")
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
        //5. Select "Nha Trang" for "Depart from" and "Sài Gòn" for "Arrive at".
        //6. Select "Soft seat with air conditioner" for "Seat type"
        //7. Select "5" for "Ticket amount"
        //8. Click on "Book ticket" button
        bookTicket.BookTicket("1/9/2022","Nha Trang","Sài Gòn","Soft seat with air conditioner","4");
        String actualMsg = bookTicket.getBookticketMsg();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg,"Message 'Ticket booked successfully!' displays.");

    }
}
