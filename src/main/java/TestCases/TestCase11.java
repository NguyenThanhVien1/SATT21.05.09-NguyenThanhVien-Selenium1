package TestCases;

import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 extends TestBase{
    @Test(description = "TC011 - User can't create account while password and PID fields are empty")
    public void TC11(){
        System.out.println();
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Register" tab
        registerPage.gotoRegister();

        //3. Enter valid email address and leave other fields empty
        // 4. Click on "Register" button
        registerPage.Register("vienz@gmail.com","","","123456789");
        String actualMsg = registerPage.getErrorMsgRegiter();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg,"An error message displayed as expected");
    }
}
