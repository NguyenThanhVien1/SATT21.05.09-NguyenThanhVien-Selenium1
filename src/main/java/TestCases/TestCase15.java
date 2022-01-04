package TestCases;

import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.TimeTable;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase15 extends TestBase{
    @Test(description = "TC10 - User can book 1 ticket at a time")
    public void TC15(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimeTable timeTable = new TimeTable();

        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Login" tab
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        //3. Click on "Timetable" tab
        loginPage.gotoTimeTable();
        //4. Click on "check price" link of the route from "Đà Nẵng" to "Sài Gòn"
        timeTable.getCheckPrice();
        String actualMsg = timeTable.getTicketTableShow();
        String expectedMsg = "Ticket price from Đà Nẵng to Sài Gòn";
        Assert.assertEquals(actualMsg, expectedMsg,"'Ticket Price' page is loaded." + "Ticket table shows 'Ticket price from Đà Nẵng to Sài Gòn'.");

    }
}
