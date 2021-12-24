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

public class TestCase4 {
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
    public void TC04(){
        System.out.println("TC01 - Login page displays when un-logged User clicks on 'Book ticket' tab ");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoBookticket();
        String actualMsg = Constant.WEBDRIVER.getCurrentUrl();
        String expectedMsg = "http://www.railway.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";
        Assert.assertEquals(actualMsg, expectedMsg,"Login not displays when user un-logged after user click on 'Book ticket' tab");
    }
}
