package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
        //locators
        private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
        private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
        private final By lbWelcomeMessage = By.xpath("//div[@class='account']/strong");
        private final By tabBookticket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
        private final By lbErrorMessage = By.xpath("<p class='message error LoginForm'>\n" + "Invalid username or password. Please try again.        </p>");
        //Elemnets
        protected  WebElement getTabLogin(){
            return Constant.WEBDRIVER.findElement(tabLogin);
        }
        protected  WebElement getTabBookticketPage(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
        protected  WebElement getTabLogout(){
            return Constant.WEBDRIVER.findElement(tabLogout);
        }
        protected  WebElement getlbWelcomeMessage(){
            return Constant.WEBDRIVER.findElement(lbWelcomeMessage);
        }
        protected  WebElement gettabBookTicket() {return Constant.WEBDRIVER.findElement(tabBookticket);}
        protected  WebElement getlbErrorMessage(){return Constant.WEBDRIVER.findElement(lbErrorMessage);}
        //Methods
        public String getWelcomeMessage(){
            return this.getlbWelcomeMessage().getText();
        }
        public String getErrorMessage(){return this.getlbErrorMessage().getText();}
        public LoginPage gotoLoginPage(){
            this.getTabLogin().click();
            return new LoginPage();
        }
        public LoginPage gotoBookticket(){
            this.gettabBookTicket().click();
            return new LoginPage();
        }
}
