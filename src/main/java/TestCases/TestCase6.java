package TestCases;

import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 extends TestBase{
    @Test(description = "TC06 - Additional pages display once user logged in")
    public void TC06() {
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Login" tab
        loginPage.gotoLoginPage();

        //3. Enter valid Email and Password and  4. Click on "Login" button
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Additional pages display");
    }
}
