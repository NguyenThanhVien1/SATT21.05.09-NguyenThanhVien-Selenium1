package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5 extends TestBase{


    @Test(description = "TC05 - System shows message when user enters wrong password several times ")
    public void TC05(){
        System.out.println();
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        // 1. Navigate to QA Railway Website
        homePage.open();

        //2. Click on "Login" tab
            loginPage.gotoLoginPage();

            //3. Enter valid information into "Username" textbox except "Password" textbox.
        //4. Click on "Login" button
        //5. Repeat step 3 three more times.
        loginPage.MultiBookticket();
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "An error message not display");
    }
}
