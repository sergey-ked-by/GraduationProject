package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    private final String TITLE_LOCATOR = ".title";
    private final String FIRST_NAME_INPUT_LOCATOR = "[data-test='firstName']";
    private final String LAST_NAME_INPUT_LOCATOR = "[data-test='lastName']";
    private final String POSTAL_CODE_INPUT_LOCATOR = "[data-test='postalCode']";
    private final String CONTINUE_BUTTON_LOCATOR = "[data-test='continue']";
    private final String FINISH_BUTTON_LOCATOR = "[data-test='finish']";
    private final String COMPLETE_HEADER_LOCATOR = ".complete-header";

    private final SelenideElement title = $(TITLE_LOCATOR);
    private final SelenideElement firstNameInput = $(FIRST_NAME_INPUT_LOCATOR);
    private final SelenideElement lastNameInput = $(LAST_NAME_INPUT_LOCATOR);
    private final SelenideElement postalCodeInput = $(POSTAL_CODE_INPUT_LOCATOR);
    private final SelenideElement continueButton = $(CONTINUE_BUTTON_LOCATOR);
    private final SelenideElement finishButton = $(FINISH_BUTTON_LOCATOR);
    private final SelenideElement completeHeader = $(COMPLETE_HEADER_LOCATOR);

    public SelenideElement getTitle() {
        return title;
    }

    public void fillInCheckoutInfo(String firstName, String lastName, String postalCode) {
        firstNameInput.shouldBe(Condition.visible, Condition.editable).setValue(firstName);
        lastNameInput.setValue(lastName);
        postalCodeInput.setValue(postalCode);
    }

    public void continueCheckout() {
        continueButton.click();
    }

    public void finishCheckout() {
        finishButton.click();
    }

    public SelenideElement getCompleteHeader() {
        return completeHeader;
    }
}
