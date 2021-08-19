package pagesSelenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public SelenideElement column = $("#center_column");
    public ElementsCollection products = $$("#homefeatured li div div h5 a");

    @Step("Get product")
    public void getProduct() {
        if (column.exists()) {
            // strict verification
            products.shouldHave(CollectionCondition.itemWithText("Blouse"));
            //not strict verification
            products.filter(text("Blouse")).shouldHave(CollectionCondition.sizeGreaterThan(0));
        } else {
            products.shouldHave(CollectionCondition.size(0));
        }
    }

    @Step("Click to product {product}")
    public void clickToProduct(String product) {
        products.findBy(Condition.exactText(product)).click();
    }

    @Step("Click to add  product")
    public void clickToAddToCart(String text) {
        $(byText(text)).click();
    }

    @Step("Click proceed")
    public void clickToProceed(String text) {
        $(byText(text)).click();
    }
    @Step("Click proceed2")
    public void clickToProceed2(String text) {
        $(byCssSelector(text)).click();
    }
    @Step("Click proceed3")
    public void clickToProceed3(String text) {
        $(byCssSelector(text)).click();
    }

    @Step("Click toAgree")
    public void clickToAgree(String text) {
        $(byCssSelector(text)).click();
    }

    @Step("Click Payment")
    public void clickPayment(String text) {
        $(byCssSelector(text)).click();
    }
    @Step("Click Confirmation")
    public void clickConfirmation(String text) {
        $(byCssSelector(text)).click();
    }

    @Step("Checking the completion ")
    public void checkCompletion(String text) {
        $(text).shouldHave(text("Your order on My Store is complete."));


    }
}
