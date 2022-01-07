package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class MyTicket extends GeneralPage {
    //locator
    private final By Cancelbnt = By.xpath("//td[text()='1']/following-sibling::td[text()='Sài Gòn']/following-sibling::td[text()='Nha Trang']/..//input[@value='Cancel']");
    private final By ArriveStationdisplay = By.xpath("//td[text()='Phan Thiết']");
    private final By txtDepartdate = By.xpath("//td[text()='Phan Thiết']");
    private final By Errormessage = By.xpath("//div[@class='error message']");

    ////Dynamic Locator
    String CancelBnt = "//td[text()='1']/following-sibling::td[text()='Sài Gòn']/following-sibling::td[text()='Nha Trang']/..//input[@value='Cancel']";

    //Elements
    protected WebElement getCancelbnt(String Id, String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(Cancelbnt);
    }
    protected  WebElement getArriveStationdisplay(){return Constant.WEBDRIVER.findElement(ArriveStationdisplay);}

    protected WebElement gettxtDepartdate(){return Constant.WEBDRIVER.findElement(txtDepartdate);}

    protected WebElement getErrormessage(){return Constant.WEBDRIVER.findElement(Errormessage);}

    //method
    public void getCancelBnt(String Id, String depart, String arrive) {
        this.getCancelbnt(Id, depart, arrive).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
    public void gettxtDepartDate(){this.gettxtDepartdate().sendKeys("1234");}

    public String getArriveStationDisplay(){return this.getArriveStationdisplay().getText();}

    public String getErrorMessage(){return this.getErrormessage().getText();}

    public boolean CancelRemove(String Id, String depart, String arrive) {
        try {
            return this.getCancelbnt(Id, depart, arrive).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
