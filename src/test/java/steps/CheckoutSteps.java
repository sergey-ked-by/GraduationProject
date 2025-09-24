package steps;


import io.qameta.allure.Step;
import pages.CheckoutPage;

import static com.codeborne.selenide.Condition.text;

public class CheckoutSteps {
    private final CheckoutPage checkoutPage = new CheckoutPage();

    @Step("Verify that the checkout page is opened")
    public void verifyCheckoutPageIsOpened() {
        checkoutPage.getTitle().shouldHave(text("Checkout: Your Information"));
    }

    @Step("Filling in checkout info with First Name: {firstName}, Last Name: {lastName}, Postal Code: {postalCode}")
    public void fillInCheckoutInfo(String firstName, String lastName, String postalCode) {
        checkoutPage.fillInCheckoutInfo(firstName, lastName, postalCode);
    }

    @Step("Continue checkout")
    public void continueCheckout() {
        checkoutPage.continueCheckout();
        checkoutPage.getTitle().shouldHave(text("Checkout: Overview"));
    }

    @Step("Verify that the checkout overview page is opened")
    public void verifyCheckoutOverviewPageIsOpened() {
        checkoutPage.getTitle().shouldHave(text("Checkout: Overview"));
    }

    @Step("Finish checkout")
    public void finishCheckout() {
        checkoutPage.finishCheckout();
    }

    @Step("Verify that checkout is complete")
    public void verifyCheckoutIsComplete() {
        checkoutPage.getCompleteHeader().shouldHave(text("Thank you for your order!"));
    }
}
