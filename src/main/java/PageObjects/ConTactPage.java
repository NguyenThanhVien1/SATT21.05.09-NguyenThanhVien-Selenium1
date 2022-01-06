package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConTactPage {
    //locator
    private final By Contactlb = By.xpath("//a[@href='/Page/Contact.cshtml']");

    //Elemnets
    protected WebElement getContactlb() {
        return Constant.WEBDRIVER.findElement(Contactlb);
    }

    //method
    public void gotoConTact() {
        this.getContactlb().click();
    }

}
