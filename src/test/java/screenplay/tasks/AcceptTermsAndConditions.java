package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import screenplay.interactions.RemoveBitnamiBanner;

public class AcceptTermsAndConditions implements Task {

    public static AcceptTermsAndConditions checkbox() {
        return new AcceptTermsAndConditions();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        actor.attemptsTo(RemoveBitnamiBanner.now());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        WebElement checkbox = driver.findElement(By.xpath(
            "//input[@type='checkbox' and contains(@name,'agree')]"
        ));
        js.executeScript("arguments[0].click();", checkbox);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        WebElement continueBtn = driver.findElement(By.id("button-payment-method"));
        js.executeScript("arguments[0].click();", continueBtn);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
