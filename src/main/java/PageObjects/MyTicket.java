package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicket extends GeneralPage{
    //locator
    private final By Cancelbnt = By.xpath("//td[text()='1']/following-sibling::td[text()='Nha Trang']/following-sibling::td[text()='Phan Thiết']/..//input[@value='Cancel']");
    private final By Departlb = By.xpath("//td[text()='Nha Trang']");

    //Elements
    protected WebElement getCancelbnt() {return Constant.WEBDRIVER.findElement(Cancelbnt);}

    //method
    public void getCancelBnt(){this.getCancelbnt().click();
        Constant.WEBDRIVER.switchTo().alert().accept();}

}
