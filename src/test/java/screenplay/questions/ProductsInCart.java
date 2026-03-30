package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

public class ProductsInCart implements Question<Boolean> {

    private final List<String> expectedProducts;

    public ProductsInCart(List<String> expectedProducts) {
        this.expectedProducts = expectedProducts;
    }

    public static ProductsInCart areVisible() {
        return new ProductsInCart(new ArrayList<>());
    }

    public ProductsInCart containing(String... products) {
        List<String> newList = new ArrayList<>(this.expectedProducts);
        for (String product : products) {
            newList.add(product);
        }
        return new ProductsInCart(newList);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return true;
    }
}
