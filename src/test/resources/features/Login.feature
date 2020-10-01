Feature: como cliente quiero ingresar con mis credenciales al sitio de compras
 #usu: paola@automation.com, pass: 12345

  @Pao
  Scenario Outline: Login exitoso
    Given el cliente ingresa a la pagina inicio sesion
    When el cliente hace click en el boton  <boton>
    Then el cliente verifica que fue redireccionado a la pagina de "Login"
    When el cliente ingresa mail: <email>
    And el cliente ingresa pass: <pass>
    And el cliente hace click en el boton  <boton>
    Then  el cliente verifica que fue redireccionado a la pagina de "My Account"

    Examples:
      | boton   | email                | pass  |
      | Sign in | paola@automation.com | 12345 |