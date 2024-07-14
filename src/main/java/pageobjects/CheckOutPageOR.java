package pageobjects;

import org.openqa.selenium.By;

public class CheckOutPageOR {
    public static By checkoutPageTitle = By.xpath("//div[@id='page_wrapper']//span[@class='title']");

    public static By checkout = By.xpath("//button[@id='checkout']");
    public static By firstName = By.xpath("//input[@id='first-name']");
    public static By lastName = By.xpath("//input[@id='last-name']");
    public static By zipCode = By.xpath("//input[@id='postal-code']");

    public static By continueSubmit = By.xpath("//input[@type='submit' and @id='continue']");

    public static By finish = By.xpath("//button[@id='finish']");

    public static By confirmation = By.xpath("//div[@id='checkout_complete_container']//h2");



}
