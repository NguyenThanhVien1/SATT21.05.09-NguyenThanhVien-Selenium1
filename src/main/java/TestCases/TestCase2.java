package TestCases;

import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends TestBase{


    @Test(description = "TC02 - User can't login with blank 'Username' textbox")
    public void TC02(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Login" tab
        loginPage.gotoLoginPage();

        //3. User doesn't type any words into "Username" textbox but enter valid information into "Password" textbox
        //4. Click on "Login" button
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualMsg, expectedMsg,"An error message display");
    }
}
