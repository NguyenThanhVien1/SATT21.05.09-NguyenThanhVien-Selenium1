package TestCases;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10() {
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        registerPage.gotoRegister();
        registerPage.Register(registerPage.randomEmail(), Constant.PASSWORD, registerPage.randomPID(), Constant.PASSWORD);

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Register' tab");
        registerPage.gotoRegister();

        System.out.println("3. Enter information of the created account in Pre-condition and 4. Click on 'Register' button");
        System.out.println("4. Click on 'Register' button");
        registerPage.Register(registerPage.autoEmail, Constant.PASSWORD, registerPage.randomPID(), Constant.PASSWORD);
        String actualMsg = registerPage.getErrorMsgRegiter();
        String expectedMsg = "This email address is already in use.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message 'This email address is already in use.' displays above the form.");

    }
}
