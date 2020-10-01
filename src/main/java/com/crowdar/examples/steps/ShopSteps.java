package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ShopSteps extends PageSteps {

    @Given("el cliente está logueado")
    public void elClienteEstáLogueado(String userType) {

    }

    @Given("el cliente ingresa a la pagina inicio sesion")
    public void elClienteIngresaALaPaginaInicioSesion() {
        Injector._page(ShopHomePage.class).go();
        Injector._page(ShopHomePage.class).verificarHome();
    }

    @When("el cliente hace click en el boton  (.*)")
    public void elClienteHaceClickEnElBoton(String boton) {
        switch (boton){
            case "Sign In": Injector._page(ShopHomePage.class).loginButtonClick(); break;
            case "Add to cart": Injector._page(ArticlePage.class).clickBoton(); break;
            case "Proceed to checkout": Injector._page(ShoppingCartPage.class).clickBoton(boton); break;
            case "Terminos y Servicios": Injector._page(ShoppingCartPage.class).clickBoton(boton); break;
            case "Pay by bank wire":
            case "I confirm my order": Injector._page(ShoppingCartPage.class).clickBoton(boton); break;
        }
        if (boton == "T-SHIRTS" || boton == "WOMEN" || boton == "DRESSES") {
            Injector._page(CatalogPage.class).clickBoton(boton);
        }
        if (boton == "T-shirts") {
            Injector._page(CatalogPage.class).clickItem(boton);
        }
        if (boton == "Pay by bank wire" || boton == "Pay by bank wire") {
            Injector._page(ShoppingCartPage.class).clickBoton(boton);
        }
    }

    @Then("el cliente verifica que fue redireccionado a la pagina de (.*)")
    public void elClienteVerificaQueFueRedireccionadoALaPagina(String pagina) {
                Injector._page(ShopHomePage.class).redirectScreen(pagina);
        }

    @When("el cliente ingresa mail:(.*)")
    public void elClienteIngresaMail(String email) {
        Injector._page(ShopHomePage.class).completeEmail(email);
    }

    @And("el cliente ingresa pass: (.*)")
    public void elClienteIngresaPass(String pass) {
        Injector._page(ShopHomePage.class).completePass(pass);
    }

    @And("ingresa la cantidad (.*) de articulos")
    public void clickeaLaCantidadCantidadArticulos(String cantidad) {
        Injector._page(ShoppingCartPage.class).cantidadArticulos(cantidad);
    }

    @And("el cliente hace click en el boton <forma_pago>")
    public void elClienteHaceClickEnElBotonForma_pago() {
    }

    @Then("se verifica el (.*)")
    public void seVerificaEl(String label) {
        Injector._page(ShoppingCartPage.class).verificarTotal(label);
    }
}
