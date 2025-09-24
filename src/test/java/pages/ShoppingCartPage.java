package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage {
    private final String TITLE_LOCATOR = ".title";
    private final String CART_ITEMS_LOCATOR = ".cart_item";
    private final String CHECKOUT_BUTTON_LOCATOR = "[data-test='checkout']";

    private final SelenideElement title = $(TITLE_LOCATOR);
    private final ElementsCollection cartItems = $$(CART_ITEMS_LOCATOR);
    private final SelenideElement checkoutButton = $(CHECKOUT_BUTTON_LOCATOR);

    public SelenideElement getTitle() {
        return title;
    }

    public ElementsCollection getCartItems() {
        return cartItems;
    }

    public void goToCheckout() {
        checkoutButton.click();
    }
}