package TestCases;

import Constant.Constant;
import PageObjects.ChangePassword;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase9 extends TestBase{
    @Test(description = "TC09 - User can change password")
    public void TC09(){
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

        //3. Click on "Change Password" tab
        changePassword.gotoChangePassword();
        //4. Enter valid value into all fields. and 5. Click on "Change Password" button
        changePassword.ChangePassword("12345678","123456789","123456789");
        String actualMsg = changePassword.getSuccessfullyPassword();
        String expectedMsg = "Your password has been updated!";
        Assert.assertEquals(actualMsg, expectedMsg,"A message display");

    }
}
