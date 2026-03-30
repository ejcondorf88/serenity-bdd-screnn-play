package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class OpenCartPage {
    
    // Home Page
    public static final Target FEATURED_PRODUCTS_SECTION = Target.the("Featured products section")
            .locatedBy("h3:contains('Featured')");
    
    public static final Target ADD_TO_CART_BUTTON_FOR_PRODUCT = Target.the("Add to cart button for product {0}")
            .locatedBy("button[onclick='cart.add({0});']");
    
    public static final Target PRODUCT_NAME = Target.the("Product name")
            .locatedBy("//div[contains(@class,'product-thumb')]//h4/a[text()='{0}']");
    
    // Cart
    public static final Target CART_DROPDOWN = Target.the("Cart dropdown button")
            .locatedBy("#cart button.dropdown-toggle");
    
    public static final Target CART_ITEMS_COUNT = Target.the("Cart items count")
            .locatedBy("#cart-total");
    
    public static final Target VIEW_CART_LINK = Target.the("View cart link")
            .locatedBy("a[title='Shopping Cart']");
    
    public static final Target CHECKOUT_LINK_FROM_CART = Target.the("Checkout link from cart")
            .locatedBy("#cart .dropdown-menu a[href*='checkout/checkout']");
    
    public static final Target CART_EMPTY_MESSAGE = Target.the("Cart empty message")
            .locatedBy("#cart .dropdown-menu p.text-center");
    
    // Checkout Step 1 - Options
    public static final Target GUEST_CHECKOUT_RADIO = Target.the("Guest checkout radio")
            .locatedBy("input[value='guest']");
    
    public static final Target CONTINUE_ACCOUNT_BUTTON = Target.the("Continue account button")
            .locatedBy("#button-account");
    
    // Checkout Step 2 - Guest Information
    public static final Target FIRST_NAME_FIELD = Target.the("First name field")
            .locatedBy("#input-payment-firstname");
    
    public static final Target LAST_NAME_FIELD = Target.the("Last name field")
            .locatedBy("#input-payment-lastname");
    
    public static final Target EMAIL_FIELD = Target.the("Email field")
            .locatedBy("#input-payment-email");
    
    public static final Target TELEPHONE_FIELD = Target.the("Telephone field")
            .locatedBy("#input-payment-telephone");
    
    public static final Target COMPANY_FIELD = Target.the("Company field")
            .locatedBy("#input-payment-company");
    
    public static final Target ADDRESS_1_FIELD = Target.the("Address 1 field")
            .locatedBy("#input-payment-address-1");
    
    public static final Target ADDRESS_2_FIELD = Target.the("Address 2 field")
            .locatedBy("#input-payment-address-2");
    
    public static final Target CITY_FIELD = Target.the("City field")
            .locatedBy("#input-payment-city");
    
    public static final Target POSTCODE_FIELD = Target.the("Post code field")
            .locatedBy("#input-payment-postcode");
    
    public static final Target COUNTRY_DROPDOWN = Target.the("Country dropdown")
            .locatedBy("#input-payment-country");
    
    public static final Target REGION_DROPDOWN = Target.the("Region dropdown")
            .locatedBy("#input-payment-zone");
    
    public static final Target CONTINUE_GUEST_BUTTON = Target.the("Continue guest button")
            .locatedBy("#button-guest");
    
    // Checkout Step 3 - Shipping Method
    public static final Target SHIPPING_METHOD_RADIO = Target.the("Shipping method radio")
            .locatedBy("input[name='shipping_method']");
    
    public static final Target FLAT_SHIPPING_RATE = Target.the("Flat shipping rate")
            .locatedBy("input[value*='flat.flat']");
    
    public static final Target CONTINUE_SHIPPING_BUTTON = Target.the("Continue shipping button")
            .locatedBy("#button-shipping-method");
    
    // Checkout Step 4 - Payment Method
    public static final Target TERMS_CHECKBOX = Target.the("Terms and conditions checkbox")
            .locatedBy("input[name='agree']");
    
    public static final Target CONTINUE_PAYMENT_BUTTON = Target.the("Continue payment button")
            .locatedBy("#button-payment-method");
    
    // Checkout Step 5 - Confirm Order
    public static final Target CONFIRM_ORDER_BUTTON = Target.the("Confirm order button")
            .locatedBy("#button-confirm");
    
    // Success Page
    public static final Target ORDER_SUCCESS_MESSAGE = Target.the("Order success message")
            .locatedBy("div#content h1");
    
    public static final Target SUCCESS_ALERT = Target.the("Success alert")
            .locatedBy(".alert-success");
    
    // Cart Page
    public static final Target CART_PRODUCT_NAME = Target.the("Cart product name")
            .locatedBy("//div[@id='content']//table[contains(@class,'table')]//td[contains(text(),'{0}')]");
    
    public static final Target CART_PRODUCT_QUANTITY = Target.the("Cart product quantity")
            .locatedBy("//div[@id='content']//table[contains(@class,'table')]//td[contains(text(),'{0}')]/following-sibling::td//input[contains(@name,'quantity')]");
    
    public static final Target CART_CHECKOUT_BUTTON = Target.the("Cart checkout button")
            .locatedBy("//div[@id='content']//a[contains(@href,'checkout/checkout')]");
    
    private OpenCartPage() {
        // Utility class
    }
}
