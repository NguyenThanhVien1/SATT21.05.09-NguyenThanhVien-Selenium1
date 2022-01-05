package TestCases;

import Constant.Constant;
import PageObjects.ConTactPage;
import PageObjects.HomePage;
import PageObjects.LogOutPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 extends TestBase{
    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC06() {
        System.out.println("TC06 - User is redirected to Home page after logging out");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        LogOutPage logOutPage = new LogOutPage();
        ConTactPage conTactPage = new ConTactPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with valid Email and Password");
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Contact' tab");
        conTactPage.gotoConTact();

        System.out.println(" 4. Click on 'Log out' tab");
        logOutPage.gotoLogOutLb();
        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Home page displays.'Log out' tab is disappeared.");
    }
}
