package TestCases;

import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase1 extends TestBase {


    @Test(description = "TC01 - User can log  into Railway with valid username and password")
    public void TC01() {
        System.out.println("TC01 - User can log  into Railway with valid username and password");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        loginPage.gotoLoginPage();

        System.out.println("//3. Enter valid Email and Password and  4. Click on 'Login' button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

}
