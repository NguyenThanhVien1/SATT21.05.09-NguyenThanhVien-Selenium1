package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePassword extends GeneralPage{
    //locator
    private final By CurrentPassword = By.id("currentPassword");
    private final By NewPassword = By.id("newPassword");
    private final By ConfirmPassword = By.id("confirmPassword");
    private final By ErrorMsg = By.xpath("//p[@class='message error']");
    private final By ChangePassword = By.xpath("//input[@value='Change Password']");
    private final By ChangeSuccessFully = By.xpath("//p[@class='message success']");

    //Elemnets
    protected WebElement getConfirmPassword(){return Constant.WEBDRIVER.findElement(ConfirmPassword);}
    protected WebElement getNewPassword(){return Constant.WEBDRIVER.findElement(NewPassword);};
    protected WebElement getCurrentPassword(){return Constant.WEBDRIVER.findElement(CurrentPassword);}
    protected WebElement getErrorMsg(){return Constant.WEBDRIVER.findElement(ErrorMsg);}
    protected WebElement getChangePassword(){return Constant.WEBDRIVER.findElement(ChangePassword);}
    protected WebElement getChangeSuccessFully(){return Constant.WEBDRIVER.findElement(ChangeSuccessFully);}

    //method
    public void ChangePassword(String CurrentPassword,String NewPassword,String ConfirmPassword){
        this.getCurrentPassword().sendKeys(CurrentPassword);
        this.getNewPassword().sendKeys(NewPassword);
        this.getConfirmPassword().sendKeys(ConfirmPassword);
        this.getChangePassword().click();
    }

    public String getSuccessfullyPassword(){return this.getChangeSuccessFully().getText();}

    public String getErrorMessageChangePassword(){return this.getErrorMsg().getText();}

}
