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

public class ProceedToCheckout implements Task {

    public static ProceedToCheckout asGuest() {
        return new ProceedToCheckout();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        actor.attemptsTo(RemoveBitnamiBanner.now());

        Target checkoutButton = Target.the("Checkout button")
            .locatedBy("//div[@id='content']//a[contains(@href,'checkout/checkout') and contains(@class,'btn-primary')]");

        actor.attemptsTo(
            WaitUntil.the(checkoutButton, isVisible()).forNoMoreThan(5).seconds()
        );

        WebElement btn = driver.findElement(By.xpath(
            "//div[@id='content']//a[contains(@href,'checkout/checkout') and contains(@class,'btn-primary')]"
        ));
        js.executeScript("arguments[0].scrollIntoView(true);", btn);
        js.executeScript("arguments[0].click();", btn);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
