package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTable extends GeneralPage{
    //locator

    private final By Bookticket17inTable = By.xpath("//td[text()='Huế']/following-sibling::td[text()='Nha Trang']/../td/a[text()='book ticket']");
    private final By DepartForm = By.xpath("//select[@name='ArriveStation']/option[@value='1']");
    private final By ArriveAt = By.xpath("//select[@name='DepartStation']/option[@value='5']");
    private final By CheckPrice = By.xpath("//a[@href='TicketPricePage.cshtml?id1=4&id2=1']");

    //Elemnets

    protected WebElement getBookticketinTable(){return Constant.WEBDRIVER.findElement(Bookticket17inTable);}
    protected WebElement getDepartForm(){return Constant.WEBDRIVER.findElement(DepartForm);}
    protected WebElement getArriveAt(){return Constant.WEBDRIVER.findElement(ArriveAt);}
    protected WebElement getCheckprice(){return Constant.WEBDRIVER.findElement(CheckPrice);}

    //method
    public void Bookticket17(){this.getBookticketinTable().click();}

    public String getDepartFormDisplay(){return getDepartForm().getText();}

    public String getArriveAtDisplay(){return getArriveAt().getText();}

    public void getCheckPrice(){this.getCheckprice().click();}

}
