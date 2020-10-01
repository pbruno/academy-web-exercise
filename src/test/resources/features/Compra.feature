Feature: Compra online

  Como cliente
  quiero comprar desde el sitio de compras
  para salir el fin de semana

  @Ignore
  Scenario Outline: Compra exitosa
   # Given el cliente está logueado
    When el cliente hace click en el boton  <catalogo>
    Then el cliente verifica que fue redireccionado a la pagina de "Catalog"
    And el cliente hace click en el boton  <articulo>
    Then el cliente verifica que fue redireccionado a la pagina de "Artículo"
    And ingresa la cantidad <cantidad> de articulos
    When el cliente hace click en el boton  "Add to cart"
    And el cliente hace click en el boton  "Proceed to checkout"
    Then  el cliente verifica que fue redireccionado a la pagina de "Shopping Cart Summary"
    Then se verifica el "subtotal"
    And el cliente hace click en el boton  "Proceed to checkout"
    Then el cliente verifica que fue redireccionado a la pagina de "Addresses"
    And el cliente hace click en el boton  "Proceed to checkout"
    Then  el cliente verifica que fue redireccionado a la pagina de "Shipping"
    And el cliente hace click en el boton  "Terminos y Servicios"
    And el cliente hace click en el boton  "Proceed to checkout"
    Then  el cliente verifica que fue redireccionado a la pagina de "Shipping"
    And el cliente hace click en el boton  "Proceed to checkout"
    Then  el cliente verifica que fue redireccionado a la pagina de "Payment Method"
    And el cliente hace click en el boton  <forma_pago>
    Then  el cliente verifica que fue redireccionado a la pagina de "Order Summary"
    And el cliente hace click en el boton  "I confirm my order"
    Then el cliente verifica que fue redireccionado a la pagina de  "Order Confirmation"

    Examples:
      | catalogo | articulo | cantidad | forma_pago       |
      | Women    | Blouse   | 2        | Pay by check     |
      | T-SHIRTS | T-shirts | 3        | Pay by bank wire |
