package TestCases;

import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 extends TestBase{
    @Test(description = "TC07 - User can create new account")
    public void TC07(){
        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        //1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Register" tab
        registerPage.gotoRegister();

        //3. Enter valid information into all fields and  4. Click on "Register" button
        registerPage.Register("","","","");
        String actualMsg = registerPage.getSuccessfully();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg,"A message displayed as expected");
    }
}
