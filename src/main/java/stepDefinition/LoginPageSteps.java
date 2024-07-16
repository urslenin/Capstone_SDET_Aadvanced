package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPageOR;
import testbase.BaseClass;
import utils.GlobalVariable;
import utils.GlobalVariableHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.GlobalVariable.GLOBAL_URL;

public class LoginPageSteps extends BaseClass {
    Map<String, String> localMapCredentials = new HashMap<>();


    @Given("Driver gets Application URL {string}")
    public void driver_gets_application_url(String beforeSuiteURL) throws InterruptedException {
        openPage(globalURL);
        System.out.println("VALUE FROM GETTER AND SETTER > " +GlobalVariableHolder.getInstance().getValue(GLOBAL_URL));
        wait(2);
    }

    @When("Application Page title is loaded as expected {string}")
    public void application_page_title_is_loaded_as_expected(String expectedTitle) throws InterruptedException {
        verifyTitle("Login", expectedTitle);
        wait(2);
    }

    @Then("User enters username")
    public void user_enters_username() {
        enterTextBox("Username", LoginPageOR.userNameXpath, getMappedCredentials("username"));
    }

    @Then("User enters password")
    public void user_enters_password() {
        enterTextBox("Password", LoginPageOR.passwordXpath,  getMappedCredentials("password"));
    }

    @Then("User clicks login button")
    public void user_clicks_login_button() throws InterruptedException {
        wait(2);
        clickOnElement("LoginBtn", LoginPageOR.loginBtnXpath);
    }

    @Then("User confirms successful login by checking page title {string}")
    public void user_confirms_successful_login_by_checking_page_title(String expectedTitle) throws InterruptedException {
        verifyTitle("ProductPage", expectedTitle);
        wait(2);
    }
}
