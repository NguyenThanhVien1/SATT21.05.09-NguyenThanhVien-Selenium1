package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TimeTable extends GeneralPage {
    //locator
    private final By BookticketinTable = By.xpath("//td[text()='Huế']/following-sibling::td[text()='Nha Trang']/../td/a[text()='book ticket']");
    private final By cbbDepartForm = By.xpath("//select[@name='ArriveStation']/option[@value='1']");
    private final By cbbArriveAt = By.xpath("//select[@name='DepartStation']/option[@value='5']");
    private final By CheckPrice = By.xpath("//td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/..//a[@href='TicketPricePage.cshtml?id1=1&id2=2']");
    private final By TicketTableShow = By.xpath("//th[text()='Ticket price from Đà Nẵng to Sài Gòn']");

    //dynamic locator
    String linkCheckPrice = "//td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/..//a[text()='check price']";

    //Elemnets
    protected WebElement getBookticketinTable() {
        return Constant.WEBDRIVER.findElement(BookticketinTable);
    }

    protected WebElement getDepartForm() {
        return Constant.WEBDRIVER.findElement(cbbDepartForm);
    }

    protected WebElement getArriveAt() {
        return Constant.WEBDRIVER.findElement(cbbArriveAt);
    }

    protected WebElement getCheckprice() {
        return Constant.WEBDRIVER.findElement(CheckPrice);
    }

    protected WebElement getTicketTableshow() {
        return Constant.WEBDRIVER.findElement(TicketTableShow);
    }

    protected WebElement getLinkCheckPrice(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(linkCheckPrice, depart, arrive)));
    }

    //method
    public void Bookticket() {
        this.getBookticketinTable().click();
    }

    public void getCheckPrice() {
        this.getCheckprice().click();
    }

    public String getTicketTableShow() {
        return getTicketTableshow().getText();
    }

    public void ClickLinkCheckPrice(String depart, String arrive) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.getLinkCheckPrice(depart, arrive).getText();
    }

}
