package TestCases;

import Constant.Constant;
import PageObjects.ChangePassword;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends TestBase{
    @Test(description = "TC10 - User can't create account with 'Confirm password' is not the same with 'Password'")
    public void TC10(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ChangePassword changePassword = new ChangePassword();

        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Login" tab
        loginPage.gotoLoginPage();

        //2. Login with valid account
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        //3. Enter valid information into all fields except "Confirm password" is not the same with "Password"
        //4. Click on "Register" button
        changePassword.gotoChangePassword();
        changePassword.ChangePassword("123456789","12345678","123456");
        String actualMsg = changePassword.getErrorMessageChangePassword();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg,"An error message display");

    }
}
