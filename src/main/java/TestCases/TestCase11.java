package TestCases;

import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 extends TestBase {
    @Test(description = "TC011 - User can't create account while password and PID fields are empty")
    public void TC11() {
        System.out.println();
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        registerPage.gotoRegister();

        System.out.println("3. Enter valid email address and leave other fields empty and ");
        System.out.println("4. Click on 'Register' button");
        registerPage.Register(Constant.USERNAME, "", Constant.PASSWORD, "");
        String actualMsg = registerPage.getErrorMsgRegiter();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "An error message displayed as expected");

        String actualMsg2 = registerPage.getPasswordErrMsg();
        String expectedMsg2 = "Invalid password length";
        Assert.assertEquals(actualMsg2, expectedMsg2, "'Password' field error msg is not display as expected");
    }
}
