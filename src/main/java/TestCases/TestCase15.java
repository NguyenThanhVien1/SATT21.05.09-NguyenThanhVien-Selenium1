package TestCases;

import Common.JsonHelper;
import Common.Utilities;
import Constant.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.TimeTable;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase15 extends TestBase{
    @Test(description = "'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page",dataProvider = "data-provider")
    public void TC15(String departStation, String arriveAt, String HS , String SS,String SSC, String HB, String SBC, String SB){
        System.out.println("'Ticket price' page displays with ticket details after clicking on 'check price' link in 'Train timetable' page");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimeTable timeTable = new TimeTable();

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on 'Login' tab");
        loginPage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Timetable' tab");
        loginPage.gotoTimeTable();

        System.out.println("4. Click on 'check price' link of the route from 'Đà Nẵng' to 'Sài Gòn'");
        timeTable.ClickLinkCheckPrice(departStation,arriveAt);
        String actualMsg = timeTable.getTicketTableShow();
        String expectedMsg = "Ticket price from Đà Nẵng to Sài Gòn";
        Assert.assertEquals(actualMsg, expectedMsg,"'Ticket Price' page is loaded." + "Ticket table shows 'Ticket price from Đà Nẵng to Sài Gòn'.");

        String actualMsg2 = timeTable.getSeatTypePrice("HS");
        String expectedMsg2 = HS;
        Assert.assertEquals(actualMsg, expectedMsg,"Price is not correct");

        String actualMsg3 = timeTable.getSeatTypePrice("SS");
        String expectedMsg3 = SS;
        Assert.assertEquals(actualMsg, expectedMsg,"Price is not correct");

        String actualMsg4 = timeTable.getSeatTypePrice("SSC");
        String expectedMsg4 = SSC;
        Assert.assertEquals(actualMsg, expectedMsg,"Price is not correct");

        String actualMsg5 = timeTable.getSeatTypePrice("HB");
        String expectedMsg5 = HB;
        Assert.assertEquals(actualMsg, expectedMsg,"Price is not correct");

        String actualMsg6 = timeTable.getSeatTypePrice("SB");
        String expectedMsg6 = SB;
        Assert.assertEquals(actualMsg, expectedMsg,"Price is not correct");

        String actualMsg7 = timeTable.getSeatTypePrice("SBC");
        String expectedMsg7 = SBC;
        Assert.assertEquals(actualMsg, expectedMsg,"Price is not correct");
    }
    @DataProvider(name = "data-provider")
    public Object[][] dataProvider(){
        String filePath = Utilities.getProjectPath() + "/src/main/java/TestCases/data.json";
        JsonObject jsonpObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC15 = jsonpObject.getAsJsonObject("TC15");
        String departStation = dataTC15.get("Depart Station").getAsString();
        String arriveAt = dataTC15.get("Arrive Station").getAsString();
        String HS = dataTC15.get("HS").getAsString();
        String SS = dataTC15.get("SS").getAsString();
        String SSC = dataTC15.get("SSC").getAsString();
        String HB = dataTC15.get("HB").getAsString();
        String SB = dataTC15.get("SB").getAsString();
        String SBC = dataTC15.get("SBC").getAsString();
        Object[][] object = new Object[][]{
                {departStation, arriveAt,HS,SS,SSC,HB,SB,SBC}
        };
        return object;
    }
}
