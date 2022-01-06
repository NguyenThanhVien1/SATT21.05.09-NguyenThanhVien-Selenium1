package PageObjects;

import Common.Constant;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class RegisterPage extends GeneralPage {
    //locator
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmpassword = By.id("confirmPassword");
    private final By RegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By txtPID = By.id("pid");
    private final By bntRegiter = By.xpath("//input[@value='Register']");
    private final By SuccessMsg = By.xpath("//p[text()=\"You're here\"]");
    private final By lblPasswordErrMsg = By.xpath("//li/label[@for='password']/following-sibling::label");
    private final By lblPIDErrMsg = By.xpath("//li/label[@for='pid']/following-sibling::label");

    //Elements
    protected WebElement getEmail(){return Constant.WEBDRIVER.findElement(txtEmail);}
    protected  WebElement getPassword(){return Constant.WEBDRIVER.findElement(txtPassword);}
    protected  WebElement getConfirmpassword(){return Constant.WEBDRIVER.findElement(txtConfirmpassword);}
    protected  WebElement getRegisterErrorMsg(){return Constant.WEBDRIVER.findElement(RegisterErrorMsg);}
    protected  WebElement getPID(){return Constant.WEBDRIVER.findElement(txtPID);}
    protected  WebElement getRegiter(){return Constant.WEBDRIVER.findElement(bntRegiter);}
    protected WebElement getSuccessMsg(){return Constant.WEBDRIVER.findElement(SuccessMsg);}
    protected WebElement getLblPasswordErrMsg() {return Constant.WEBDRIVER.findElement(lblPasswordErrMsg);}
    protected WebElement getLblPIDErrMsg() {return Constant.WEBDRIVER.findElement(lblPIDErrMsg);}

    //Method
    public void Register(String Email,String Password,String PID,String ConfirmPassword){

        this.getEmail().sendKeys(Email);
        this.getPassword().sendKeys(Password);
        this.getConfirmpassword().sendKeys(ConfirmPassword);
        this.getPID().sendKeys(PID);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        this.getRegiter().click();
    }
    public String getPasswordErrMsg() {return this.getLblPasswordErrMsg().getText();}

    public String getPIDErrMsg() {return this.getLblPIDErrMsg().getText();}

    public String getSuccessfully(){return this.getSuccessMsg().getText();}

    public String getErrorMsgRegiter(){return this.getRegisterErrorMsg().getText();}

    public String autoEmail;

    public String randomEmail() {
        String generateEmail = RandomStringUtils.randomAlphabetic(5);
        autoEmail = generateEmail + "@gmail.com";
        return autoEmail;
    }

    public String randomPID() {
        String AutoPID = RandomStringUtils.randomNumeric(8);
        return AutoPID;
    }

}
