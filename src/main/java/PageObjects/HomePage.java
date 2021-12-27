package PageObjects;

import Constant.Constant;

public class HomePage extends GeneralPage {
    public void open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAIlWAY_URL);

    }
}
