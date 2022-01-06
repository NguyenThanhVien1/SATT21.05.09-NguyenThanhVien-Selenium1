package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase8 extends TestBase {
    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Login" tab
        loginPage.gotoLoginPage();

        //3. Enter username and password of account hasn't been activated. 4. Click on "Login" button
        loginPage.login("vienq@gmail.com", "123456789");
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "An error message display");
    }
}
