package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageobjects.LoginPageOR;
import pageobjects.ProductPageOR;
import testbase.BaseClass;

import java.util.List;


public class ProductPageSteps extends BaseClass {
    Logger logger = Logger.getLogger(ProductPageSteps.class);
    int badgesSize=0;

    @Given("User available on product {string} Page")
    public void user_available_in_Product_Page(String product) throws InterruptedException {
        wait(2);
        verifyElementText("ProductPage", ProductPageOR.productPageTitle, product);
        wait(2);
    }
    @When("User adds below products")
    public void application_page_title_is_loaded_as_expected(DataTable productList) throws Throwable {
        List<List<String>> data = productList.asLists(String.class);

        for (List<String> columns : data) {
            logger.info(columns.get(0));
            clickOnElement(columns.get(0), ProductPageOR.addToCart(columns.get(0)));
            wait(1);
        }
        logger.info("Product List Size : "+ data.get(0).size());
        badgesSize = data.get(0).size();
    }

    @Then("User confirms the no of items added into the cart")
    public void user_confirms_the_no_of_items_added_into_the_cart() throws InterruptedException {
        wait(1);
        verifyElementText("ProductPage", ProductPageOR.shoppingCartBadges, String.valueOf(badgesSize));
    }

    @Then("User clicks on Shopping Cart Link")
    public void user_clicks_on_shopping_cart_Link() throws InterruptedException {
        wait(1);
        moveToElement("ShoppingCart", ProductPageOR.shoppingCartLink);
        clickOnElement("ShoppingCart", ProductPageOR.shoppingCartLink);
    }

}
