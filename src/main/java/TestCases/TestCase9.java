package TestCases;

import Constant.Constant;
import PageObjects.ChangePassword;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase9 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    ChangePassword changePassword = new ChangePassword();

    @Test(description = "TC09 - User can't change password when 'New Password' and 'Confirm Password' are different.")
    public void TC09() {
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegister();
        registerPage.Register(registerPage.randomEmail(), Constant.PASSWORD, registerPage.randomPID(), Constant.PASSWORD);

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        loginPage.gotoLoginPage();

        System.out.println("2. Login with valid account");
        loginPage.login(registerPage.autoEmail, Constant.PASSWORD);

        System.out.println("3. Click on 'Change Password' tab");
        changePassword.gotoChangePassword();

        System.out.println("4. Enter valid information into \"Current Password\" textbox but enter \"a123:\"/{}!@$\\\" into \"New Password\" textbox and \"b456:\"/{}!@$\\\" into \"Confirm Password\"");
        changePassword.ChangePassword(Constant.PASSWORD, "a123:\"/{}!@$\\\"", "b456:\"/{}!@$\\\"");
        String actualMsg = changePassword.getErrorMessageChangePassword();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "An error message display");

    }
}
