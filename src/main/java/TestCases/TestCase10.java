package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends TestBase{
    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = new RegisterPage();

        //1. Navigate to QA Railway Website
        homePage.open();

       //2. Click on "Register" tab
        registerPage.gotoRegister();

        //3. Enter information of the created account in Pre-condition
        //4. Click on "Register" button
        registerPage.Register("thanhle@logigear.com","123456789","12345678","123456789");
        String actualMsg = registerPage.getErrorMsgRegiter();
        String expectedMsg = "This email address is already in use.";
        Assert.assertEquals(actualMsg, expectedMsg,"Error message 'This email address is already in use.' displays above the form.");

    }
}
