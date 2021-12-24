package TestCases;

import Common.Utilities;
import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase5 {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");

        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executable\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC05(){
        System.out.println("TC05 - System shows message when user enters wrong password several times ");
        HomePage homePage = new HomePage();
        homePage.open();
        int i;

            LoginPage loginPage = homePage.gotoLoginPage();
            for (i=1; i<=4;i++) {
                loginPage.InvalidPassword(Constant.USERNAME,"123456");
            }
        String actualMsg = loginPage.login(Constant.USERNAME, "12345").getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "An error message not display");
    }
}
