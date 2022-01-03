package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicket extends GeneralPage{
    //locator
    private final By DepartDate = By.xpath("//select[@name='Date']");
    private final By DepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By ArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By SeatType = By.xpath("//select[@name='SeatType']");
    private final By TicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By BookticketSuccessfully = By.xpath("//h1[@align='center']");
    private final By Bookticketbnt = By.xpath("//input[@value='Book ticket']");

    //Elemnets
    protected WebElement getDepartDate(){return Constant.WEBDRIVER.findElement(DepartDate);}
    protected WebElement getDepartFrom(){return Constant.WEBDRIVER.findElement(DepartFrom);}
    protected WebElement getArriveAt(){return Constant.WEBDRIVER.findElement(ArriveAt);}
    protected WebElement getSeatType(){return Constant.WEBDRIVER.findElement(SeatType);}
    protected WebElement getTicketAmount(){return Constant.WEBDRIVER.findElement(TicketAmount);}
    protected WebElement getBookTicketMsg(){return Constant.WEBDRIVER.findElement(BookticketSuccessfully);}
    protected WebElement getBookticketbnt(){return Constant.WEBDRIVER.findElement(Bookticketbnt);}

    //method
    public void BookTicket(String Departdate,String Departfrom, String Arriveat, String SeatType,String TicketAmount){
        this.getDepartDate().sendKeys(Departdate);
        this.getDepartFrom().sendKeys(Departfrom);
        this.getArriveAt().sendKeys(Arriveat);
        this.getSeatType().sendKeys(SeatType);
        this.getTicketAmount().sendKeys(TicketAmount);
        this.getBookticketbnt().click();

    }
    public String getBookticketMsg(){
        return this.getBookTicketMsg().getText();
    }
}
