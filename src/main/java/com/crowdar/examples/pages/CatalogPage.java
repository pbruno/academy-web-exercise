package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CatalogPage extends PageBaseShop{


    public CatalogPage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";

    }

    private final String BUTTON_TSHIRTS_CSS_SELECTOR = "#block_top_menu > ul > li:nth-child(3)";
    private final String BUTTON_ITEMNAME_CSS_SELECTOR = "#center_column > ul > li > div > div.right-block > h5 > a";
  //  private final String DIV_CONTENTSCENE_XPATH = "//*[@id=\"center_column\"]/div[1]/div";

    private final String TITLE_CAT_NAME_CSS_SELECTOR = "#center_column > h1 > span.cat-name";

   /* public void verifyCatalog(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.xpath(DIV_CONTENTSCENE_XPATH)), "El elemento no esta visible");
      //  Assert.assertEquals(getWebElement(By.cssSelector(TITLE_CAT_NAME_CSS_SELECTOR)).getText(),,"T-SHIRTS");
        System.out.println("Estoy en catalogo"  );
    }*/

    public void clickBoton(String boton) {
        switch (boton) {
            case "T-SHIRTS":
                clickElement(By.cssSelector(BUTTON_TSHIRTS_CSS_SELECTOR));
                System.out.println("Click en t-shirt catalog");
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                break;
            case "WOMEN":
                System.out.println("WOMEN");
                break;
            case "DRESSES":
                System.out.println("DRESSES");
                break;
        }
    }
        public void clickItem(String boton) {
                switch (boton) {
                    case "T-shirt":
                        if (isElementPresentAndDisplayed(By.cssSelector(BUTTON_ITEMNAME_CSS_SELECTOR))) {
                            clickElement(By.cssSelector(BUTTON_ITEMNAME_CSS_SELECTOR));
                        }
                        System.out.println("Click en t-shirt catalog");
                        //  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS)
                break;
                }
        }

    }