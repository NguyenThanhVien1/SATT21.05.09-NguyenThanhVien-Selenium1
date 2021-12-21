package PageObjects;

import Constant.Constant;

public class HomePage extends GeneralPage {
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAIlWAY_URL);
        return this;
    }
}
