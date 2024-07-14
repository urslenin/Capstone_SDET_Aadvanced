Feature: Login to SauceLabDemo Application

  Background:

  @regression, @SauceLabEnd2End
  Scenario Outline:  Login to Application Using Examples and Credentials From DataProvider and place orders

    Given Driver gets Application URL "<urlFromBeforeSuite>"
    When Application Page title is loaded as expected "<loginPageTitle>"
    Then User enters username
    Then User enters password
    Then User clicks login button
    Then User confirms successful login by checking page title "<productPageTitle>"
    # Product Page
    Given User available on product "Product" Page
    When User adds below products
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    Then User confirms the no of items added into the cart
    Then User clicks on Shopping Cart Link
    # Checkout Page
    Given User available on your cart "Your Cart" Page
    Then User verifies cart information and clicks on Check Out
    # Checkout Your Information
    When User available on your information "Checkout: Your Information" Page
    Then User enters first name in "<first name>"
    Then User enters last name in "<last name>"
    Then User enters zip code in "<zip code>"
    Then User clicks on continue
    # Checkout: Overview
    Given User available on overview "Checkout: Overview" Page
    Then User clicks on finish
    # Order: Overview
    Then User verifies order by "Thank you for your order!"
    Examples:
      | urlFromBeforeSuite | loginPageTitle | username         | password         | productPageTitle | first name | last name | zip code |
      | urlFromBeforeSuite | Swag Labs      | fromDataProvider | fromDataProvider | Swag Labs        | James      | David     | 6000393  |

