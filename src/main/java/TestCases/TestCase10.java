package TestCases;

import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends TestBase{
    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10(){
        System.out.println("TC10 - User can't create account with an already in-use email");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Register' tab");
        registerPage.gotoRegister();

        System.out.println("3. Enter information of the created account in Pre-condition and 4. Click on 'Register' button");
        registerPage.Register(Constant.USERNAME,Constant.PASSWORD,Constant.PASSWORD,registerPage.randomPID());
        String actualMsg = registerPage.getErrorMsgRegiter();
        String expectedMsg = "This email address is already in use.";
        Assert.assertEquals(actualMsg, expectedMsg,"Error message 'This email address is already in use.' displays above the form.");

    }
}
