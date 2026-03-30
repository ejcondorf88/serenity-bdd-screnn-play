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
import screenplay.interactions.RemoveBitnamiBanner;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToCart implements Task {
    
    public static NavigateToCart page() {
        return new NavigateToCart();
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Remove banner first
        actor.attemptsTo(RemoveBitnamiBanner.now());
        
        // Click on cart dropdown button to open it
        Target cartDropdown = Target.the("Cart dropdown button")
            .locatedBy("#cart button.dropdown-toggle");
        
        actor.attemptsTo(
            WaitUntil.the(cartDropdown, isVisible()).forNoMoreThan(5).seconds()
        );
        
        WebElement cartBtn = driver.findElement(By.cssSelector("#cart button.dropdown-toggle"));
        js.executeScript("arguments[0].click();", cartBtn);
        
        // Wait for dropdown to open
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Click on "View Cart" link in dropdown
        WebElement viewCartLink = driver.findElement(By.xpath(
            "//div[@id='cart']//ul[contains(@class,'dropdown-menu')]//a[contains(@href,'checkout/cart')]"
        ));
        js.executeScript("arguments[0].click();", viewCartLink);
        
        // Wait for cart page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
