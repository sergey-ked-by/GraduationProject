package steps;

import io.qameta.allure.Step;
import pages.ProductsPage;
import pages.ShoppingCartPage;

import static com.codeborne.selenide.Condition.text;

public class ProductsSteps {
    private final ProductsPage productsPage = new ProductsPage();

    @Step("Verifying that the products page is opened")
    public void verifyProductsPageIsOpened() {
        productsPage.getTitle().shouldHave(text("Products"));
    }

    @Step("Adding product '{productName}' to the cart")
    public void addProductToCart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @Step("Go to shopping cart and verify page is opened")
    public void goToShoppingCart() {
        productsPage.goToShoppingCart();
        new ShoppingCartPage().getTitle().shouldHave(text("Your Cart"));
    }
}
