# language: es
@e2e @compra @regression
Característica: Compra como invitado en OpenCart
  Como usuario no registrado
  Quiero poder realizar una compra sin crear una cuenta
  Para poder adquirir productos de forma rápida

  @critical @smoke @happy-path
  Escenario: Realizar una compra exitosa como invitado
    Dado que el usuario está en la página principal de la tienda
    Cuando agrega el producto "iPhone" al carrito
    Y agrega el producto "MacBook" al carrito
    Y navega al carrito de compras
    Entonces debería visualizar los productos en el carrito:
      | Producto | Cantidad |
      | iPhone   | 1        |
      | MacBook  | 1        |
    Cuando procede al checkout
    Y selecciona la opción "Guest Checkout"
    Y completa el formulario de información personal con:
      | Campo          | Valor           |
      | First Name     | Juan            |
      | Last Name      | Pérez           |
      | Email          | juan@test.com   |
      | Telephone      | 5551234567      |
      | Address 1      | Calle Falsa 123 |
      | City           | Ciudad de México|
      | Post Code      | 01000           |
      | Country        | Mexico          |
      | Region/State   | Ciudad de México|
    Y selecciona el método de envío
    Y acepta los términos y condiciones
    Y confirma la orden
    Entonces debería visualizar el mensaje de confirmación "Your order has been placed!"
