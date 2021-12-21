package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
        //Locators
        private final By _txtUsername = By.xpath("//input[@id='username']");
        private final By _txtPassword = By.xpath("//input[@id='password']");
        private final By _bntLogin = By.xpath("//input[@value='login']");
        private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

        //Elements
        public WebElement getTxtUsername()
        {
            return Constant.WEBDRIVER.findElement(_txtUsername);
        }
        public WebElement getTxtPassword()
        {
            return Constant.WEBDRIVER.findElement(_txtPassword);
        }
        public WebElement getBntLogin()
        {
            return Constant.WEBDRIVER.findElement(_bntLogin);
        }
        public WebElement getlblLoginErrorMsg()
        {
            return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
        }

        //Method
        public HomePage login(String username, String password){
            //Submit login credentials
            this.getTxtUsername().sendKeys(username);
            this.getTxtPassword().sendKeys(password);
            this.getBntLogin().click();
            return new HomePage();
        }
}
