package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTable extends GeneralPage{
    //locator

    private final By Bookticket17inTable = By.xpath("//td[text()='Huế']/following-sibling::td[text()='Nha Trang']/../td/a[text()='book ticket']");
    private final By DepartForm = By.xpath("//select[@name='ArriveStation']/option[@value='1']");
    private final By ArriveAt = By.xpath("//select[@name='DepartStation']/option[@value='5']");
    private final By CheckPrice = By.xpath("//td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/..//a[@href='TicketPricePage.cshtml?id1=1&id2=2']");
    private final By TicketTableShow = By.xpath("//th[text()='Ticket price from Đà Nẵng to Sài Gòn']");

    //Elemnets

    protected WebElement getBookticketinTable(){return Constant.WEBDRIVER.findElement(Bookticket17inTable);}
    protected WebElement getDepartForm(){return Constant.WEBDRIVER.findElement(DepartForm);}
    protected WebElement getArriveAt(){return Constant.WEBDRIVER.findElement(ArriveAt);}
    protected WebElement getCheckprice(){return Constant.WEBDRIVER.findElement(CheckPrice);}
    protected WebElement getTicketTableshow(){return  Constant.WEBDRIVER.findElement(TicketTableShow);}

    //method
    public void Bookticket17(){this.getBookticketinTable().click();}

    public void getCheckPrice(){this.getCheckprice().click();}

    public  String getTicketTableShow(){return getTicketTableshow().getText();}

}
