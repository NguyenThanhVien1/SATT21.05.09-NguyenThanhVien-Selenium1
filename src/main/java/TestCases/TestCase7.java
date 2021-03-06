package TestCases;

import Common.Constant;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 extends TestBase {
    @Test(description = "User can create new account")
    public void TC07() {
        System.out.println("User can create new account");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Register' tab");
        registerPage.gotoRegister();

        System.out.println("3. Enter valid information into all fields and ");
        System.out.println("4. Click on 'Register' button");
        registerPage.Register(registerPage.randomEmail(), Constant.PASSWORD, registerPage.randomPID(), Constant.CONFIRMPASSWORD);

        String actualMsg = registerPage.getSuccessfully();
        String expectedMsg = "You're here";
        Assert.assertEquals(actualMsg, expectedMsg, "A message displayed as expected");
    }

}
