Feature: Eliminar un usuario existente
  Como empleado administrativo deseo eliminar un usuario de la plataforma OrangeHRM
  que haya finalizado su contrato laboral

  Scenario: Eliminar un usuario de la plataforma OrangeHRM
    Given que el administrador se encuentra autenticado en el sitio web OrangeHRM
    When el administrador selecciona el usuario que quiere eliminar y presiona delete
    Then el sistema deberia eliminarlo de la base de datos