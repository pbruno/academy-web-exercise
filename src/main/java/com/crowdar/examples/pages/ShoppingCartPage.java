package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ShoppingCartPage extends PageBaseShop {



    public ShoppingCartPage(RemoteWebDriver driver) {
        super(driver);
        this.url="";
    }
    //pantalla Summary
    private final String H1_TITLE_ID = "cart_title";
    private final String SPAN_TOTAL_CSS_SELECTOR = "#cart_summary > tfoot > tr:nth-child(7) > td.total_price_container.text-right > span";
    //private final String BUTTON_ADDCANT_CSS_SELECTOR = "#cart_quantity_up_4_16_0_372086 > span > i";
    //private final String BUTTON_PROCEEDCHECKOUT_SUMMARY_CSS_SELECTOR = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium";
    private final String INPUT_CANTARTICULOS_ID = "#quantity_wanted";
    private final String BUTTON_PAYMENTMETHOD_CSS_SELECTOR = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a";
    private final String BUTTON_ORDERSUMMARY_CSS_SELECTOR = "#cart_navigation > button";


    public void cantidadArticulos(String cantidad){
        completeField(By.id(INPUT_CANTARTICULOS_ID), cantidad);
        clickElement(By.cssSelector(SPAN_TOTAL_CSS_SELECTOR));
    }

    public void verificarTotal(String label){
        if (label == "Subtotal"){
            System.out.println("subtotal");
        } else {
            System.out.println("total");
        }

    }

    public void clickBoton(String boton){
        switch (boton){
            case "Proceed to checkout": clickearProceedCheckout(); break;
            case "Terminos y Servicios": click("store.input_checkbox"); break;
            case "Pay by bank wire": clickElement(By.cssSelector(BUTTON_PAYMENTMETHOD_CSS_SELECTOR)); break;
            case "I confirm my order": clickElement(By.cssSelector(BUTTON_ORDERSUMMARY_CSS_SELECTOR)); break;
        }
    }

    //Metodo para clickear todos los botones llamados "Proceed to checkout"
    private void clickearProceedCheckout() {
        if(isPresent("store.button_proceed_shipping")){
            click("store.button_proceed_shipping");
        } else{
            if(isPresent("store.button_proceedcheckout_addresses")){
                click("store.button_proceedcheckout_addresses");
            } else {
                if(isPresent("store.button_proceedcheckout_summary")){
                    click("store.button_proceedcheckout_summary");
                } else{
                    if(isPresent("store.button_proceedcheckout_article")){
                        click("store.button_proceedcheckout_article");
                    }
                }
            }
        }
    }
}
