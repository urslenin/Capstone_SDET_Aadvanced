package pageobjects;

import org.openqa.selenium.By;

public class ProductPageOR {

    public static By productPageTitle = By.xpath("//div[@id='page_wrapper']//span[@class='title']");

    //Dynamic Xpath
    public static By addToCart(String product) {
       return By.xpath("//div[contains(@class,'inventory_item_name') and text()='"+ product +
                       "']//ancestor::div[@class='inventory_item_description']//button[text()='Add to cart']");
    }

    public static By shoppingCartBadges = By.xpath("//span[@class='shopping_cart_badge']");
    public static By shoppingCartLink = By.xpath("//a[@class='shopping_cart_link']");
}
