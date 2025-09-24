package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class ProductsPage {
    private final String TITLE_LOCATOR = ".title";
    private final String INVENTORY_ITEMS_LOCATOR = ".inventory_item";
    private final String SHOPPING_CART_LINK_LOCATOR = ".shopping_cart_link";

    private final SelenideElement title = $(TITLE_LOCATOR);
    private final ElementsCollection inventoryItems = $$(INVENTORY_ITEMS_LOCATOR);
    private final SelenideElement shoppingCartLink = $(SHOPPING_CART_LINK_LOCATOR);

    public void addProductToCart(String productName) {
        final String INVENTORY_ITEM_NAME_LOCATOR = ".inventory_item_name";
        final String ADD_TO_CART_BUTTON_LOCATOR = "button";
        for (SelenideElement item : inventoryItems) {
            if (item.$(INVENTORY_ITEM_NAME_LOCATOR).getText().equals(productName)) {
                item.$(ADD_TO_CART_BUTTON_LOCATOR).click();
                break;
            }
        }
    }

    public void goToShoppingCart() {
        executeJavaScript("arguments[0].click();", shoppingCartLink);
    }
}
