package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogOutPage {
    //locators
    private final By LogOutlb = By.xpath("//a[@href='/Account/Logout']");

    //Elemnets
    protected WebElement getLogOutlb() {
        return Constant.WEBDRIVER.findElement(LogOutlb);
    }

    //Methods
    public void gotoLogOutLb() {
        this.getLogOutlb().click();
    }

    public boolean isLogoutDisplay() {
        try {
            return this.getLogOutlb().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
