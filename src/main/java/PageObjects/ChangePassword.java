package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ChangePassword extends GeneralPage {
    //locator
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By ErrorMsg = By.xpath("//p[@class='message error']");
    private final By bntChangePassword = By.xpath("//input[@value='Change Password']");
    private final By ChangeSuccessFully = By.xpath("//p[@class='message success']");

    //Elemnets
    protected WebElement getConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    protected WebElement getNewPassword() {
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }

    ;

    protected WebElement getCurrentPassword() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }

    protected WebElement getErrorMsg() {
        return Constant.WEBDRIVER.findElement(ErrorMsg);
    }

    protected WebElement getChangePassword() {
        return Constant.WEBDRIVER.findElement(bntChangePassword);
    }

    protected WebElement getChangeSuccessFully() {
        return Constant.WEBDRIVER.findElement(ChangeSuccessFully);
    }

    //method
    public void ChangePassword(String CurrentPassword, String NewPassword, String ConfirmPassword) {
        this.getCurrentPassword().sendKeys(CurrentPassword);
        this.getNewPassword().sendKeys(NewPassword);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        this.getConfirmPassword().sendKeys(ConfirmPassword);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        this.getChangePassword().click();
    }

    public String getSuccessfullyPassword() {
        return this.getChangeSuccessFully().getText();
    }

    public String getErrorMessageChangePassword() {
        return this.getErrorMsg().getText();
    }

}
