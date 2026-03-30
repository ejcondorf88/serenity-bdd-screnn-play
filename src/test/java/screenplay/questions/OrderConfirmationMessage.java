package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.ui.OpenCartPage;

public class OrderConfirmationMessage implements Question<String> {
    
    public static OrderConfirmationMessage displayed() {
        return new OrderConfirmationMessage();
    }
    
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(OpenCartPage.ORDER_SUCCESS_MESSAGE).answeredBy(actor);
    }
}
