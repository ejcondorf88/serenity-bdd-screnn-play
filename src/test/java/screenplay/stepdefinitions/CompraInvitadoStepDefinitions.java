package screenplay.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import screenplay.model.Product;
import screenplay.model.UserData;
import screenplay.questions.OrderConfirmationMessage;
import screenplay.questions.ProductsInCart;
import screenplay.tasks.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.*;

public class CompraInvitadoStepDefinitions {

    @Given("que el usuario esta en la pagina principal de la tienda")
    public void que_el_usuario_esta_en_la_pagina_principal_de_la_tienda() {
        Actor actor = theActorCalled("Guest User");
        actor.attemptsTo(
            Open.url("http://opencart.abstracta.us/")
        );
    }

    @When("agrega el producto {string} al carrito")
    public void agrega_el_producto_al_carrito(String productName) {
        Product product = getProductByName(productName);
        theActorCalled("Guest User").attemptsTo(
            AddProduct.toCart(product)
        );
    }

    @And("navega al carrito de compras")
    public void navega_al_carrito_de_compras() {
        theActorCalled("Guest User").attemptsTo(
            NavigateToCart.page()
        );
    }

    @Then("deberia visualizar los productos en el carrito:")
    public void deberia_visualizar_los_productos_en_el_carrito(DataTable dataTable) {
        theActorCalled("Guest User").should(
            seeThat(ProductsInCart.areVisible().containing("iPhone", "MacBook"), equalTo(true))
        );
    }

    @When("procede al checkout")
    public void procede_al_checkout() {
        theActorCalled("Guest User").attemptsTo(
            ProceedToCheckout.asGuest()
        );
    }

    @And("selecciona la opcion Guest Checkout")
    public void selecciona_la_opcion_guest_checkout() {
        theActorCalled("Guest User").attemptsTo(
            SelectGuestCheckout.option()
        );
    }

    @And("completa el formulario de informacion personal con:")
    public void completa_el_formulario_de_informacion_personal_con(DataTable dataTable) {
        UserData userData = new UserData.Builder()
            .withFirstName("Juan")
            .withLastName("Perez")
            .withEmail("juan@test.com")
            .withTelephone("5551234567")
            .withAddress("Calle Falsa 123")
            .withCity("Mexico City")
            .withPostCode("01000")
            .withCountry("Mexico")
            .withRegion("Mexico City")
            .build();

        theActorCalled("Guest User").attemptsTo(
            FillPersonalInformation.withData(userData)
        );
    }

    @And("selecciona el metodo de envio")
    public void selecciona_el_metodo_de_envio() {
        theActorCalled("Guest User").attemptsTo(
            SelectShippingMethod.defaultOption()
        );
    }

    @And("acepta los terminos y condiciones")
    public void acepta_los_terminos_y_condiciones() {
        theActorCalled("Guest User").attemptsTo(
            AcceptTermsAndConditions.checkbox()
        );
    }

    @And("confirma la orden")
    public void confirma_la_orden() {
        theActorCalled("Guest User").attemptsTo(
            ConfirmOrder.now()
        );
    }

    @Then("deberia visualizar el mensaje de confirmacion Your order has been placed!")
    public void deberia_visualizar_el_mensaje_de_confirmacion() {
        theActorCalled("Guest User").should(
            seeThat(OrderConfirmationMessage.displayed(), equalTo("Your order has been placed!"))
        );
    }

    private Product getProductByName(String productName) {
        switch (productName) {
            case "MacBook":
                return Product.macBook();
            case "iPhone":
                return Product.iPhone();
            case "Apple Cinema 30":
                return Product.appleCinema();
            case "Canon EOS 5D":
                return Product.canonEos();
            default:
                throw new IllegalArgumentException("Producto no reconocido: " + productName);
        }
    }
}
