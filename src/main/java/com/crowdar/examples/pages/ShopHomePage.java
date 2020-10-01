package com.crowdar.examples.pages;

import com.crowdar.core.Injector;
import com.crowdar.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ShopHomePage extends PageBaseShop {

    public ShopHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = "";
    }

    private final String BUTTON_SIGNIN_CSS_SELECTOR = "#header > div.nav > div > div > nav > div.header_user_info > a";
    private final String INPUT_EMAIL_ID = "#email";
    private final String INPUT_PASS_ID = "passwd";
    private final String BUTTON2_SIGNIN_CSS_SELECTOR = "#SubmitLogin";
    private final String TITLE_H1_CSS_SELECTOR =   "#center_column > h1";
      private final String SLIDER_HOME_ID = "slider_row";
    private final String CREATE_ACCOUNT_BUTTON_CSS_SELECTOR = "#SubmitCreate";
    //private final String REGISTER_BUTTON_ID = "submitAccount";
    //private final String EMAIL_INPUT_CREATE_CSS_SELECTOR = "#email_create";
    //private final String FORM_CSS_SELECTOR = "#noSlide > h1";
    private final String EMAIL_INPUT_CREATE_CSS_SELECTOR = "#email_create";
    private final String EMAIL_INPUT_LOGIN_ID= "email";
    private final String H3_DATASHEET_CSS_SELECTOR = "#center_column > div > section:nth-child(2) > h3";
    private final String H1_TITLE_SHIPPING_CSS_SELECTOR = "#carrier_area > h1";


    // Navego Home
    public void go() {
        navigateToCompleteURL();
    }

   //Boton Sign In
    public void clickButton(String button){
        switch (button){
            case "Sign in":
                loginButtonClick();
                break;
            case "Create an account":
                System.out.println("no es el boton"  );
                //createAnAccountButton();
                break;

                      //case "Register":
             //   registerButton();
            //    break;
        }
    }

   public void loginButtonClick(){

       if (isElementPresent(By.cssSelector(BUTTON_SIGNIN_CSS_SELECTOR)) && isElementPresent(By.cssSelector(BUTTON2_SIGNIN_CSS_SELECTOR))){
           clickElement(By.cssSelector(BUTTON2_SIGNIN_CSS_SELECTOR));
           System.out.println("Login"  );
       }
        else if (isElementVisible(By.cssSelector(BUTTON_SIGNIN_CSS_SELECTOR))){
           clickElement(By.cssSelector(BUTTON_SIGNIN_CSS_SELECTOR));

       }
   }

    public void redirectScreen(String pantalla){
        switch (pantalla){
            case "Login":
                System.out.println("si estoy en login");
                verifyLoginScreen();
                break;
            case "My Account":
                   verifyMyAccountScreen();
                break;
            case "Catalog":
                verifyMyAccountScreen();
                break;
            case "Article":
                System.out.println("si estoy en Article");
                verifyArticleScreen();
                break;
            case "Addresses":
                System.out.println("si estoy en AddressesT");
                verifyAddressesScreen();
                break;
            case "Shipping":
                System.out.println("sShipping");
                verifyShippingScreen();
                break;
            case "Payment Method":
                System.out.println("Payment MethodT");
                verifyPayMethodScreen();
                break;
            case "Order Summary":
                System.out.println("Order SummaryT");
                verifyOrderSummaryScreen();
                break;
            case "Order Confirmation":
                System.out.println("Order ConfirmationT");
                verifyOrderConfirmationScreen();
                break;

        }
    }
    //case "Shopping Cart": Injector._page(ShoppingCartPage.class).verificarShoppingCartPage(); break;

    //// public void createAnAccountButton(){
       // clickElement(By.cssSelector(CREATE_ACCOUNT_BUTTON_CSS_SELECTOR));
   // }

  //  public void registerButton(){
     //   clickElement(By.id(REGISTER_BUTTON_ID));
 //   }


    // Ingreso usuario y contraseña
    public void completeEmail(String email){
        System.out.println(email);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //sleep(5000);
        completeField(By.id(EMAIL_INPUT_LOGIN_ID), email);

    }

    public void completePass(String pass){
        completeField(By.id(INPUT_PASS_ID), pass);
        System.out.println(pass);
    }

    //Verificaciones de paginas
    public void verificarHome(){
        Assert.assertTrue(isElementPresentAndDisplayed(By.id(SLIDER_HOME_ID)), "El elemento no es visible");
    }
    public void verifyLoginScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"AUTHENTICATION");
        System.out.println("LoginScren"  );
    }
    public void verifyMyAccountScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"MY ACCOUNT");
        System.out.println("pOR FIN MY ACCOUNT"  );
    }
    public void verifyCatalogScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"CATALOG");
        System.out.println("Viendo el catalogT"  );
    }
    public void verifyArticleScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(H3_DATASHEET_CSS_SELECTOR)).getText(), "DATA SHEET");
        System.out.println("Viendo el catalogT"  );
    }
    public void verifyPayMethodScreen() {
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"PLEASE CHOOSE YOUR PAYMENT METHOD");
    }
    public void verifyAddressesScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"ADDRESSES");;
    }
    public void verifyShippingScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"SHOPPING-CART SUMMARY");
    }
    public void verifyOrderSummaryScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"ORDER SUMMARY");
    }
    public void verifyOrderConfirmationScreen(){
        Assert.assertEquals(getWebElement(By.cssSelector(TITLE_H1_CSS_SELECTOR)).getText(),"ORDER CONFIRMATION");
    }


}
