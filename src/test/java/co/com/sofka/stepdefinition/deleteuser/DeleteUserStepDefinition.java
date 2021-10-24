package co.com.sofka.stepdefinition.deleteuser;

import co.com.sofka.exceptions.login.ValidationLoginOrange;
import co.com.sofka.questions.deleteuser.DeleteUser;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.sofka.exceptions.login.ValidationLoginOrange.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.deleteuser.DeleteUser.wasDelete;
import static co.com.sofka.tasks.deleteuser.DeleteUser.deleteUser;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.loginorange.DoLoginOrange.doLoginOrange;
import static co.com.sofka.userinterfaces.deleteuser.DeleteUser.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class DeleteUserStepDefinition extends Setup {

    private static final String ACTOR_NAME = "Administrador";
    private static final String USER = "Admin";
    private static final String PASSWORD = "admin123";
    private String name_before = "Hola";


    @Given("que el administrador se encuentra autenticado en el sitio web OrangeHRM")
    public void queElAdministradorSeEncuentraAutenticadoEnElSitioWebOrangeHRM() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(openLandingPage());
        theActorInTheSpotlight().attemptsTo(doLoginOrange().setUser(USER).setPassword(PASSWORD));
    }


    @When("el administrador selecciona el usuario que quiere eliminar y presiona delete")
    public void elAdministradorSeleccionaElUsuarioQueQuiereEliminarYPresionaDelete() {

        theActorInTheSpotlight().attemptsTo(deleteUser());
    }
    @Then("el sistema deberia eliminarlo de la base de datos")
    public void elSistemaDeberiaEliminarloDeLaBaseDeDatos() {
        theActorInTheSpotlight().should(
                seeThat(
                        wasDelete().setTarget(USER_NAME_COLUMNA_FILA1).setUsername("Admin").is(),
                        equalTo(false)
                ).orComplainWith(ValidationLoginOrange.class, String.format(VALIDATION_DO_NOT_MATCH, "No eliminó el usuario"))
        );
    }

}
