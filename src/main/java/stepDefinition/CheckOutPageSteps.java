package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CheckOutPageOR;
import pageobjects.LoginPageOR;
import pageobjects.ProductPageOR;
import testbase.BaseClass;

public class CheckOutPageSteps extends BaseClass {

    @Given("User available on your cart {string} Page")
    public void user_available_on_YourCartPage(String title) throws InterruptedException {
        wait(1);
        verifyElementText(title, CheckOutPageOR.checkoutPageTitle,title);
    }

    @When("User verifies cart information and clicks on Check Out")
    public void user_clicks_on_CheckOut() throws InterruptedException {
        wait(2);
        clickOnElement("CheckOut", CheckOutPageOR.checkout);
    }

    @Given("User available on your information {string} Page")
    public void user_available_on_CheckoutYourInformationPage(String pageConfirm) throws InterruptedException {
        wait(1);
        verifyElementText("Checkout: Your Information", CheckOutPageOR.checkoutPageTitle, pageConfirm);
    }

    @Then("User enters first name in {string}")
    public void user_enters_firstname(String firstName) {
        enterTextBox("FirstName", CheckOutPageOR.firstName, firstName  );
    }

    @Then("User enters last name in {string}")
    public void user_enters_lastname(String lastName) {
        enterTextBox("LastName", CheckOutPageOR.lastName, lastName  );
    }

    @Then("User enters zip code in {string}")
    public void user_enters_zipcode(String zipCode) {
        enterTextBox("ZipCode", CheckOutPageOR.zipCode, zipCode  );
    }

    @Then("User clicks on continue")
    public void user_clicks_on_Continue() {
        moveToElement("Continue", CheckOutPageOR.continueSubmit);
        clickOnElement("Continue", CheckOutPageOR.continueSubmit);
        //submitElement("Continue", CheckOutPageOR.continueSubmit);
    }

    @Given("User available on overview {string} Page")
    public void user_available_on_CheckoutOverviewPage(String pageConfirm) throws InterruptedException {
        wait(1);
        moveToElement("Checkout: Overview", CheckOutPageOR.checkoutPageTitle);
        verifyElementText("Checkout: Overview", CheckOutPageOR.checkoutPageTitle, pageConfirm);
    }

    @Then("User clicks on finish")
    public void user_clicks_on_finish() throws InterruptedException {
        moveToElement("Finish", CheckOutPageOR.finish);
        clickOnElement("Finish", CheckOutPageOR.finish);
        wait(1);
    }

    @Then("User verifies order by {string}")
    public void user_confirms_orders(String confirm) throws InterruptedException {
        verifyElementText("Confirm",CheckOutPageOR.confirmation, confirm);
        wait(1);
    }

}
