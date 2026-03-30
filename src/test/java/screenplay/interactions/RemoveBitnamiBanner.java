package screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class RemoveBitnamiBanner implements Interaction {
    
    public static RemoveBitnamiBanner now() {
        return new RemoveBitnamiBanner();
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript(
            "var banner = document.getElementById('bitnami-banner');" +
            "if (banner) banner.style.display='none';" +
            "var closeBtn = document.getElementById('bitnami-close-banner-button');" +
            "if (closeBtn) closeBtn.style.display='none';"
        );
    }
}
