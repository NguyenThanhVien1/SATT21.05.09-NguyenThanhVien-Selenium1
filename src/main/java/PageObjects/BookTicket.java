package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class BookTicket extends GeneralPage{

    //locator
    private final By BookticketSuccessfully = By.xpath("//h1[@align='center']");
    private final By Bookticketbnt = By.xpath("//input[@value='Book ticket']");
    private final By BookTicketCenter = By.xpath("//h1[@align='center']");
    private final By BookTicketError = By.xpath("//p[@class='message error']");
    private final By lblResultDepart = By.xpath("//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By lblResultArrive = By.xpath("//td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private final By lblResultSeat = By.xpath("//td[count(//th[text()='Seat Type']/preceding-sibling::th)+1]");
    private final By lblResultAmount = By.xpath("//td[count(//th[text()='Amount']/preceding-sibling::th)+1]");
    private final By lbErrorMSG = By.xpath("//label[@class='validation-error']");
    private final By cbbDepartDate = By.xpath("//select[@name='Date']");
    private final By bntApplyFilter = By.xpath("//input[@value='Apply Filter']");

    //Dynamic Locator
    String dblDepartFrom = "//select[@name ='DepartStation']//option[text()='%s']";
    String dblArriveAt = "//select[@name ='ArriveStation']  //option[text()='%s']";
    String dblSeatType = "//select[@name ='SeatType']//option[text()='%s']";
    String dblTicketAmount = "//select[@name ='TicketAmount']//option[text()='%s']";
    String dblDepartDate = "//div[@id='content']/div/form//select[@name='Date']//option[text()='%s']";
    String ccbArriveStation = "//select[@name='FilterArStation']/option[text()='%s']";

    //Elemnets
    protected WebElement getBookTicketMsg(){return Constant.WEBDRIVER.findElement(BookticketSuccessfully);}
    protected WebElement getBookticketbnt(){return Constant.WEBDRIVER.findElement(Bookticketbnt);}
    protected WebElement getBookTicketCenter(){return Constant.WEBDRIVER.findElement(BookTicketCenter);}
    protected WebElement getBookTicketError(){return Constant.WEBDRIVER.findElement(BookTicketError);}
    protected WebElement getlbErrormsg(){return Constant.WEBDRIVER.findElement(lbErrorMSG);}
    protected WebElement getbntApplyFilter(){return Constant.WEBDRIVER.findElement(bntApplyFilter);}

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

    protected WebElement getDblDepartDate(String departDate) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(dblDepartDate, departDate)));
    }

    protected WebElement getcbbArriveStation(String ccbArriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(ccbArriveStation, ccbArriveStation)));
    }


    protected WebElement getLblResultDepart() {return Constant.WEBDRIVER.findElement(lblResultDepart);}
    protected WebElement getLblResultArrive() {return Constant.WEBDRIVER.findElement(lblResultArrive);}
    protected WebElement getLblResultSeat() {return Constant.WEBDRIVER.findElement(lblResultSeat);}
    protected WebElement getLblResultAmount() {return Constant.WEBDRIVER.findElement(lblResultAmount);}

    //method
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

    public String getlbErrorMSG(){return this.getlbErrormsg().getText();}


    public void getArriveAt(String arrivalAt) {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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

    public void clickCbbArriveStation() {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        this.getcbbArriveStation("Phan Thiết").click();
        this.getbntApplyFilter().click();
    }

    public void getDepartDate(){
        Constant.getDate(7);
        this.getDblDepartDate(Constant.date).click();
    }

    public String getResultDepart() {return this.getLblResultDepart().getText();}

    public String getResultArrive() {return this.getLblResultArrive().getText();}

    public String getResultSeat() {return this.getLblResultSeat().getText();}

    public String getResultAmount() {return this.getLblResultAmount().getText();}


}
