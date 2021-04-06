# Each feature contains one feature
# Feature files use Gherkin language - bussiness language
Feature: Test the login functionality on blinklearning

  Scenario Outline: La usuario debe poder iniciar sesion
    Given el usuario abre el browser
    When el usuario ingresa el correo electronico "<emailId>"
    And el usuario ingresa la contrasena "<password>"
    And click at the login boton
#    Comento la linea 11 por no tener un usuario real para hacer comprobaciones(asserts)
#    Then obtenemos la confirmacion de que se ha logueado
    And cerrar el browser el terminar las prueba
    Examples:
      | emailId                       |   password          |
      | pdemetrius@blinklearning.com  |   pdemetriusPass@123|

