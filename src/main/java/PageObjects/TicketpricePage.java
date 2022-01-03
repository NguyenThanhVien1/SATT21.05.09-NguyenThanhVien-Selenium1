package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketpricePage {
    //locator
    private final By TicketPicelb = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
    private final By TicketPiceCenter = By.xpath("//h1[@align='center']");

    //Elements
    protected WebElement getTicketPricelb(){return Constant.WEBDRIVER.findElement(TicketPicelb);}
    protected WebElement getTicketPricecenter(){return Constant.WEBDRIVER.findElement(TicketPiceCenter);}

    //Method
    public void gotoTicketPrice(){this.getTicketPricelb().click();}
    public String GetTicketPriceCenter(){return this.getTicketPricecenter().getText();}
}
