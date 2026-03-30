package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import screenplay.interactions.RemoveBitnamiBanner;
import screenplay.model.UserData;

public class FillPersonalInformation implements Task {
    
    private final UserData userData;
    
    public FillPersonalInformation(UserData userData) {
        this.userData = userData;
    }
    
    public static FillPersonalInformation withData(UserData userData) {
        return new FillPersonalInformation(userData);
    }
    
    // Para backwards compatibility
    public static FillPersonalInformation withData(String firstName, String lastName, String email,
                                                   String telephone, String address1, String city,
                                                   String postCode) {
        UserData data = new UserData.Builder()
            .withFirstName(firstName)
            .withLastName(lastName)
            .withEmail(email)
            .withTelephone(telephone)
            .withAddress(address1)
            .withCity(city)
            .withPostCode(postCode)
            .withCountry("Mexico")
            .withRegion("Mexico City")
            .build();
        return new FillPersonalInformation(data);
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Remove banner first
        actor.attemptsTo(RemoveBitnamiBanner.now());
        
        js.executeScript("document.getElementById('input-payment-firstname').value='" + userData.getFirstName() + "';");
        js.executeScript("document.getElementById('input-payment-lastname').value='" + userData.getLastName() + "';");
        js.executeScript("document.getElementById('input-payment-email').value='" + userData.getEmail() + "';");
        js.executeScript("document.getElementById('input-payment-telephone').value='" + userData.getTelephone() + "';");
        js.executeScript("document.getElementById('input-payment-address-1').value='" + userData.getAddress1() + "';");
        js.executeScript("document.getElementById('input-payment-city').value='" + userData.getCity() + "';");
        js.executeScript("document.getElementById('input-payment-postcode').value='" + userData.getPostCode() + "';");
        
        WebElement countrySelect = driver.findElement(By.id("input-payment-country"));
        Select country = new Select(countrySelect);
        country.selectByVisibleText(userData.getCountry());
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Select Region - try to find any option or use first available
        WebElement zoneSelect = driver.findElement(By.id("input-payment-zone"));
        Select zone = new Select(zoneSelect);
        // Select first non-empty option (usually index 0 is "--- Please Select ---")
        if (zone.getOptions().size() > 1) {
            zone.selectByIndex(1); // Select first real region
        }
        
        // Click Continue button
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        WebElement continueBtn = driver.findElement(By.id("button-guest"));
        js.executeScript("arguments[0].click();", continueBtn);
        
        // Wait for shipping method to appear
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
