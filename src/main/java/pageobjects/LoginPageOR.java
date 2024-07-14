package pageobjects;

import org.openqa.selenium.By;

public class LoginPageOR {
    public static By userNameXpath = By.xpath("//input[@id='user-name']");
    public static By passwordXpath = By.xpath("//input[@id='password']");
    public static By loginBtnXpath = By.xpath("//input[@id='login-button']");
    public static By loginErrorXpath = By.xpath("//div/h3[@data-test='error']");
}
