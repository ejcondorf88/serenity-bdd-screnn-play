package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screenplay.interactions.RemoveBitnamiBanner;
import screenplay.model.Product;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProduct implements Task {

    private final Product product;

    public AddProduct(Product product) {
        this.product = product;
    }

    public static AddProduct toCart(Product product) {
        return new AddProduct(product);
    }

    public static AddProduct toCart(String productId) {
        return new AddProduct(findProductById(productId));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(RemoveBitnamiBanner.now());

        Target addButton = Target.the("Add to cart button for " + product.getName())
            .locatedBy("//button[contains(@onclick,\"cart.add('" + product.getId() + "')\")]");

        actor.attemptsTo(
            WaitUntil.the(addButton, isVisible()).forNoMoreThan(10).seconds()
        );

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement button = driver.findElement(By.xpath(
            "//button[contains(@onclick,\"cart.add('" + product.getId() + "')\")]"
        ));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        js.executeScript("arguments[0].click();", button);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(
            ExpectedConditions.textToBe(By.id("cart-total"), "0 item(s) - $0.00")
        ));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static Product findProductById(String productId) {
        switch (productId) {
            case "43": return Product.macBook();
            case "40": return Product.iPhone();
            case "42": return Product.appleCinema();
            case "30": return Product.canonEos();
            default: return new Product(productId, "Unknown", 0.0);
        }
    }
}
