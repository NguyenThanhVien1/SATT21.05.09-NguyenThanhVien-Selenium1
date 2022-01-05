package PageObjects;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BookTicket extends GeneralPage{

    //locator
    private final By DepartDate = By.xpath("//select[@name='Date']");
    private final By DepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By ArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By SeatType = By.xpath("//select[@name='SeatType']");
    private final By TicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By BookticketSuccessfully = By.xpath("//h1[@align='center']");
    private final By Bookticketbnt = By.xpath("//input[@value='Book ticket']");
    private final By BookTicketCenter = By.xpath("//h1[@align='center']");
    private final By BookTicketError = By.xpath("//p[@class='message error']");

    //Dynamic Locator
    String dblDepartFrom = "//select[@name ='DepartStation']//option[text()='%s']";
    String dblArriveAt = "//select[@name ='ArriveStation']  //option[text()='%s']";
    String dblSeatType = "//select[@name ='SeatType']//option[text()='%s']";
    String dblTicketAmount = "//select[@name='TicketAmount']//option[text()='%s']";

    //Elemnets
    protected WebElement getDepartDate(){return Constant.WEBDRIVER.findElement(DepartDate);}
    protected WebElement getDepartFrom(){return Constant.WEBDRIVER.findElement(DepartFrom);}
    protected WebElement getArriveAt(){return Constant.WEBDRIVER.findElement(ArriveAt);}
    protected WebElement getSeatType(){return Constant.WEBDRIVER.findElement(SeatType);}
    protected WebElement getTicketAmount(){return Constant.WEBDRIVER.findElement(TicketAmount);}
    protected WebElement getBookTicketMsg(){return Constant.WEBDRIVER.findElement(BookticketSuccessfully);}
    protected WebElement getBookticketbnt(){return Constant.WEBDRIVER.findElement(Bookticketbnt);}
    protected WebElement getBookTicketCenter(){return Constant.WEBDRIVER.findElement(BookTicketCenter);}
    protected WebElement getBookTicketError(){return Constant.WEBDRIVER.findElement(BookTicketError);}

    protected WebElement getDblDepartFrom(String departFrom) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblDepartFrom, departFrom)));
    }
    protected WebElement getDblArriveAt(String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblArriveAt, arriveAt)));
    }
    protected WebElement getDblSeatType(String seatType) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblSeatType, seatType)));
    }
    protected WebElement getDblTicketAmount(String ticketAmount) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblTicketAmount, ticketAmount)));
    }



    //method
    public void BookTicket(String Departdate,String Departfrom, String Arriveat, String SeatType,String TicketAmount){
        this.getDepartDate().sendKeys(Departdate);
        this.getDepartFrom().sendKeys(Departfrom);
        this.getArriveAt().sendKeys(Arriveat);
        this.getSeatType().sendKeys(SeatType);
        this.getTicketAmount().sendKeys(TicketAmount);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.getBookticketbnt().click();
    }

    public String getBookticketMsg(){
        return this.getBookTicketMsg().getText();
    }

    public String getBookticketCenter(){
        return this.getBookTicketCenter().getText();
    }

    public String getBookTicketerror(){return this.getBookTicketError().getText();}

    public void getDepartFrom(String departFrom) {
        this.getDblDepartFrom(departFrom).click();
    }

    public void getArriveAt(String arrivalAt) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblArriveAt(arrivalAt).click();
    }

    public void getSeatType(String seatType) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblSeatType(seatType).click();
    }

    public void getTicketAmount(String ticketAmount) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        this.getDblTicketAmount(ticketAmount).click();
    }

    public void clickBtnBookTicket() {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        this.getBookticketbnt().click();
    }

}
