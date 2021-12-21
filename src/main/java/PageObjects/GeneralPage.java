package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
        //locators
        private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
        private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
        private final By lbWelcomeMessage = By.xpath("//div[@class='account']/strong");

        //Elemnets
        protected  WebElement getTabLogin(){
            return Constant.WEBDRIVER.findElement(tabLogin);
        }
        protected  WebElement getTabLogout(){
            return Constant.WEBDRIVER.findElement(tabLogout);
        }
        protected  WebElement getlbWelcomeMessage(){
            return Constant.WEBDRIVER.findElement(lbWelcomeMessage);
        }

        //Methods
        public String getWelcomeMessage(){
            return this.getlbWelcomeMessage().getText();
        }
        public LoginPage gotoLoginPage(){
            this.getTabLogin().click();
            return new LoginPage();
        }
}
