package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5 extends TestBase {


    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        loginPage.gotoLoginPage();

        System.out.println("3. Login invalid password and Repeat step 3 three more times.");
        loginPage.MultiBookticket();
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "An error message not display");
    }
}
