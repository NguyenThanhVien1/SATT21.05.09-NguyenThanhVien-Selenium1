package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
        //Locators
        private final By Username = By.xpath("//input[@id='username']");
        private final By Password = By.xpath("//input[@id='password']");
        private final By Login = By.xpath("//input[@value='login']");
        private final By LoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

        //Elements
        public WebElement getTxtUsername()
        {
            return Constant.WEBDRIVER.findElement(Username);
        }
        public WebElement getTxtPassword()
        {
            return Constant.WEBDRIVER.findElement(Password);
        }
        public WebElement getBntLogin()
        {
            return Constant.WEBDRIVER.findElement(Login);
        }
        public WebElement getlblLoginErrorMsg()
        {
            return Constant.WEBDRIVER.findElement(LoginErrorMsg);
        }

        //Method
        public HomePage login(String username, String password){
            //Submit login credentials
            this.getTxtUsername().sendKeys(username);
            this.getTxtPassword().sendKeys(password);
            this.getBntLogin().click();
            return new HomePage();
        }
        public HomePage InvalidPassword(String username, String password){
            this.getTxtUsername().sendKeys("thanhle@logigear.com");
            this.getTxtPassword().sendKeys("123456");
            this.getBntLogin().click();
            return new HomePage();
        }

}
