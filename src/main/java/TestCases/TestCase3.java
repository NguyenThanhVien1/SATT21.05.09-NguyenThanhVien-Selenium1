package TestCases;

import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase{


    @Test(description = "TC01 - User cannot log into Railway with invalid password ")
    public void TC03(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Login" tab
        loginPage.gotoLoginPage();

        //3. Enter valid Email and invalid Password and 4. Click on "Login" button
        loginPage.login(Constant.USERNAME,"1234569");
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg,"An error message display");
    }
}
