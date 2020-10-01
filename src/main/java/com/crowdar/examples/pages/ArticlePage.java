package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ArticlePage extends PageBaseShop {

    public ArticlePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }


    public void clickBoton() {
        if (isPresent("store.button_addtocart_article")) {
            click("store.button_addtocart_article");
        }
    }
}