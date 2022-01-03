package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicket extends GeneralPage{
    //locator
    private final By Cancelbnt = By.xpath("//input[@value='Cancel']");

    //Elements
    protected WebElement getCancelbnt() {return Constant.WEBDRIVER.findElement(Cancelbnt);}

}
