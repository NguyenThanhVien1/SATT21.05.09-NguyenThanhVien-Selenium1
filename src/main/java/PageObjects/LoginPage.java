package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends GeneralPage {
    //Locators
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By bntLogin = By.xpath("//input[@value='Login']");
    private final By LoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By LbLogin = By.xpath("//h1[@align='center']");

    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBntLogin() {
        return Constant.WEBDRIVER.findElement(bntLogin);
    }

    public WebElement getlblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(LoginErrorMsg);
    }

    protected WebElement getLbLogin() {
        return Constant.WEBDRIVER.findElement(LbLogin);
    }

    //Method
    public void login(String username, String password) {
        //Submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.getBntLogin().click();
    }

    public void InvalidPassword(String username, String password) {
        this.getTxtUsername().sendKeys("thanhle@logigear.com");
        this.getTxtPassword().sendKeys("123456");
        this.getBntLogin().click();
    }

    public void MultiBookticket() {
        int i;
        for (i = 1; i <= 4; i++) {
            login(Constant.USERNAME, "");
        }
    }

    public String getLbLoginPage() {
        return this.getLbLogin().getText();
    }

}
