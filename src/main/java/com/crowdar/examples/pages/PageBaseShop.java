package com.crowdar.examples.pages;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.pageObjects.PageBaseWeb;
import com.crowdar.driver.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageBaseShop extends PageBaseWeb {

    public PageBaseShop(RemoteWebDriver driver) {
        super(driver);
        BASE_URL = "http://automationpractice.com/";
    }

}
