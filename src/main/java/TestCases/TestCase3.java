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

public class TestCase3 {
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
    public void TC03(){
        System.out.println("TC01 - User cannot log into Railway with invalid password ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME,"123456").getWelcomeMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form ";

        Assert.assertEquals(actualMsg, expectedMsg,"Invalid Password");
    }
}
