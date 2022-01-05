package PageObjects;

import Constant.Constant;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegisterPage extends GeneralPage {
    //locator
    private final By Email = By.id("email");
    private final By Password = By.id("password");
    private final By Confirmpassword = By.id("confirmPassword");
    private final By RegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By PID = By.id("pid");
    private final By Regiter = By.xpath("//input[@value='Register']");
    private final By SuccessMsg = By.xpath("//p[text()=\"You're here\"]");
    private final By lblPasswordErrMsg = By.xpath("//li/label[@for='password']/following-sibling::label");
    private final By lblPIDErrMsg = By.xpath("//li/label[@for='pid']/following-sibling::label");

    //Elements
    protected WebElement getEmail(){return Constant.WEBDRIVER.findElement(Email);}
    protected  WebElement getPassword(){return Constant.WEBDRIVER.findElement(Password);}
    protected  WebElement getConfirmpassword(){return Constant.WEBDRIVER.findElement(Confirmpassword);}
    protected  WebElement getRegisterErrorMsg(){return Constant.WEBDRIVER.findElement(RegisterErrorMsg);}
    protected  WebElement getPID(){return Constant.WEBDRIVER.findElement(PID);}
    protected  WebElement getRegiter(){return Constant.WEBDRIVER.findElement(Regiter);}
    protected WebElement getSuccessMsg(){return Constant.WEBDRIVER.findElement(SuccessMsg);}
    protected WebElement getLblPasswordErrMsg() {return Constant.WEBDRIVER.findElement(lblPasswordErrMsg);}
    protected WebElement getLblPIDErrMsg() {return Constant.WEBDRIVER.findElement(lblPIDErrMsg);}

    //Method
    public void Register(String Email,String Password,String PID,String ConfirmPassword){
        this.getEmail().sendKeys("vienh@gmail.com");
        this.getPassword().sendKeys("123456789");
        this.getConfirmpassword().sendKeys("123456789");
        this.getPID().sendKeys("12345678");
        this.getRegiter().click();
    }
    public String getPasswordErrMsg() {return this.getLblPasswordErrMsg().getText();}

    public String getPIDErrMsg() {return this.getLblPIDErrMsg().getText();}

    public String getSuccessfully(){return this.getSuccessMsg().getText();}

    public String getErrorMsgRegiter(){return this.getRegisterErrorMsg().getText();}

    public String autoEmail;

    public String randomEmail() {
        String generateEmail = RandomStringUtils.randomAlphabetic(6);
        autoEmail = generateEmail + "@gmail.com";
        return autoEmail;
    }

    public String randomPID() {
        String AutoPID = RandomStringUtils.randomNumeric(8);
        return AutoPID;
    }

}
