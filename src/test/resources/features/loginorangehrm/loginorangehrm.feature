Feature: Login en OrangeHRM
    como usuario administrador quiero loggearme en el sitio web OrangeHRM
    para hacer consultas y realizar cambios en la DB

  Scenario: Login exitoso
    Given quiero logearme en el sitio web de OrangeHRM
    When ingreso user and password correctas
    Then deberia iniciar sesion

  Scenario Outline: login fallido
    Given quiero logearme en el sitio web de OrangeHRM
    When ingreso credenciales no validas
    And digite
    |user|<user>|
    |password|<password>|
    Then el sistema deberia arrojar una advertencia
Examples:
    |user          |password|
    |HolaMundo     |admin123|
    |Admin         |pass123 |
    |              |        |
