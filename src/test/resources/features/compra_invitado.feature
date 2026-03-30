Feature: Compra como invitado en OpenCart
  Como usuario no registrado
  Quiero poder realizar una compra sin crear una cuenta
  Para poder adquirir productos de forma rapida

  @e2e @compra @regression @critical @smoke @happy-path
  Scenario: Realizar una compra exitosa como invitado
    Given que el usuario esta en la pagina principal de la tienda
    When agrega el producto "iPhone" al carrito
    And agrega el producto "MacBook" al carrito
    And navega al carrito de compras
    Then deberia visualizar los productos en el carrito:
      | Producto | Cantidad |
      | iPhone   | 1        |
      | MacBook  | 1        |
    When procede al checkout
    And selecciona la opcion Guest Checkout
    And completa el formulario de informacion personal con:
      | Campo          | Valor           |
      | First Name     | Juan            |
      | Last Name      | Perez           |
      | Email          | juan@test.com   |
      | Telephone      | 5551234567      |
      | Address 1      | Calle Falsa 123 |
      | City           | Ciudad de Mexico|
      | Post Code      | 01000           |
      | Country        | Mexico          |
      | Region/State   | Ciudad de Mexico|
    And selecciona el metodo de envio
    And acepta los terminos y condiciones
    And confirma la orden
    Then deberia visualizar el mensaje de confirmacion Your order has been placed!
