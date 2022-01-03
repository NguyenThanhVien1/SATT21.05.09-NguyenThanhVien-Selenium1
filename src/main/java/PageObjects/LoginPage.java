package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
        //Locators
        private final By Username = By.id("username");
        private final By Password = By.id("password");
        private final By Login = By.xpath("//input[@value='login']");
        private final By LoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
        private final By LbLogin = By.xpath("//h1[@align='center']");

        //Elements
        public WebElement getTxtUsername() {return Constant.WEBDRIVER.findElement(Username);}
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
        protected WebElement getLbLogin(){return Constant.WEBDRIVER.findElement(LbLogin);}

        //Method
        public void login (String username, String password){
            //Submit login credentials
            this.getTxtUsername().sendKeys(username);
            this.getTxtPassword().sendKeys(password);
            this.getBntLogin().click();

        }
        public void InvalidPassword(String username, String password){
            this.getTxtUsername().sendKeys("thanhle@logigear.com");
            this.getTxtPassword().sendKeys("123456");
            this.getBntLogin().click();

        }
    public void MultiBookticket(){
        int i;
        for (i=1; i<=4;i++) {
            login(Constant.USERNAME,"");
        }

    }

    public String getLbLoginPage(){return this.getLbLogin().getText();}
}
