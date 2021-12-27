package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4 extends TestBase{


    @Test(description = "TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab ")
    public void TC04(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Book ticket" tab
        loginPage.gotoBookticket();
        String actualMsg = loginPage.getLbLoginPage();
        String expectedMsg = "Login page";
        Assert.assertEquals(actualMsg, expectedMsg,"Login page displays instead of Book ticket page");
    }
}
