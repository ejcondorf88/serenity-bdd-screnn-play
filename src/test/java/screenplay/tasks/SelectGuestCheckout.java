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

public class SelectGuestCheckout implements Task {

    public static SelectGuestCheckout option() {
        return new SelectGuestCheckout();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        actor.attemptsTo(RemoveBitnamiBanner.now());

        Target guestRadio = Target.the("Guest checkout radio")
            .locatedBy("//input[@type='radio' and @name='account' and @value='guest']");

        actor.attemptsTo(
            WaitUntil.the(guestRadio, isVisible()).forNoMoreThan(10).seconds()
        );

        WebElement radio = driver.findElement(By.xpath(
            "//input[@type='radio' and @name='account' and @value='guest']"
        ));
        js.executeScript("arguments[0].scrollIntoView(true);", radio);
        js.executeScript("arguments[0].click();", radio);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        WebElement continueBtn = driver.findElement(By.id("button-account"));
        js.executeScript("arguments[0].click();", continueBtn);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
