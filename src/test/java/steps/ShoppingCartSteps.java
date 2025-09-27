package steps;

import io.qameta.allure.Step;
import pages.ShoppingCartPage;

import static com.codeborne.selenide.Condition.text;

public class ShoppingCartSteps {
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private final CheckoutSteps checkoutSteps = new CheckoutSteps();

    @Step("Verifying that the shopping cart page is opened")
    public void verifyShoppingCartPageIsOpened() {
        shoppingCartPage.getTitle().shouldHave(text("Your Cart"));
    }

    @Step("Go to checkout")
    public void goToCheckout() {
        shoppingCartPage.goToCheckout();
        try {
            com.codeborne.selenide.Selenide.switchTo().alert().accept();
        } catch (Throwable e) {
            // No alert was present, continue as usual
        }
        checkoutSteps.verifyCheckoutPageIsOpened();
    }
}
