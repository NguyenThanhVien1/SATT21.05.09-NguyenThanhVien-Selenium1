package TestCases;

import Constant.Constant;
import PageObjects.ConTactPage;
import PageObjects.HomePage;
import PageObjects.LogOutPage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase6 extends TestBase {
    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC06() {

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

        Boolean actualMsg1 = logOutPage.isLogoutDisplay();
        Assert.assertFalse(actualMsg1, "'Log out' tab is disappeared.");

        Boolean actualMsg2 = homePage.isHomePageDisplay();
        Assert.assertTrue(actualMsg2, "Home page displays.");

    }
}
