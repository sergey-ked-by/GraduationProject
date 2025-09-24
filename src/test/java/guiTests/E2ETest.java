package guiTests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import steps.CheckoutSteps;
import steps.LoginSteps;
import steps.ProductsSteps;
import steps.ShoppingCartSteps;

public class E2ETest extends BaseTest {

    @Test
    public void successfulOrderTest() {
        LoginSteps loginSteps = new LoginSteps();
        ProductsSteps productsSteps = new ProductsSteps();
        ShoppingCartSteps shoppingCartSteps = new ShoppingCartSteps();
        CheckoutSteps checkoutSteps = new CheckoutSteps();

        loginSteps.loginWithStandardUser();
        productsSteps.verifyProductsPageIsOpened();
        productsSteps.addProductToCart("Sauce Labs Backpack");
        productsSteps.goToShoppingCart();

        shoppingCartSteps.goToCheckout();
        checkoutSteps.fillInCheckoutInfo("John", "Doe", "12345");
        checkoutSteps.continueCheckout();
        checkoutSteps.verifyCheckoutOverviewPageIsOpened();
        checkoutSteps.finishCheckout();
        checkoutSteps.verifyCheckoutIsComplete();
    }

    @Test
    public void unsuccessfulLoginTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.login("invalid_user", "invalid_password");
        loginSteps.verifyErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }
}