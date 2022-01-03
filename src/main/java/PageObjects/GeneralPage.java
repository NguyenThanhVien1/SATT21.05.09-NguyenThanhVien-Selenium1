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
        private final By lbErrorMessage = By.xpath("//p[@class='message error LoginForm']");
        private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
        private final By lbChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
        private final By TimeTablebnt = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
        private final By MyTicketbnt = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");


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
        protected  WebElement gettabRegister() {return Constant.WEBDRIVER.findElement(tabRegister);}
        protected  WebElement getlbErrorMessage(){return Constant.WEBDRIVER.findElement(lbErrorMessage);}
        protected WebElement getlbChangePassword(){return Constant.WEBDRIVER.findElement(lbChangePassword);}
        protected WebElement getTimeTablebnt(){return Constant.WEBDRIVER.findElement(TimeTablebnt);}
        protected WebElement getMyTicketbnt(){return Constant.WEBDRIVER.findElement(MyTicketbnt);}

        //Methods
        public String getWelcomeMessage(){
            return this.getlbWelcomeMessage().getText();
        }
        public String getErrorMessage(){return this.getlbErrorMessage().getText();}



        public void gotoLoginPage(){
            this.getTabLogin().click();

        }
        public void gotoBookticket(){
            this.gettabBookTicket().click();

        }
        public  void gotoRegister(){
            this.gettabRegister().click();
        }

        public void gotoChangePassword(){this.getlbChangePassword().click();}
        public void gotoTimeTable(){this.getTimeTablebnt().click();}
        public void gotoMyTicket(){this.getMyTicketbnt().click();}
}
