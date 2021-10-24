package co.com.sofka.stepdefinition.vacancynew;

import co.com.sofka.exceptions.login.ValidationLoginOrange;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.sofka.exceptions.login.ValidationLoginOrange.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.loginorange.LoginOrange.loginOrange;
import static co.com.sofka.questions.vacancynew.VacancyNew.vacancyNew;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.loginorange.DoLoginOrange.doLoginOrange;
import static co.com.sofka.tasks.vacancynew.FillFieldsVacancyNew.fillFieldsVacancyNew;
import static co.com.sofka.userinterfaces.vacancynew.VacancyNew.FILE_NAME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class VacancyNewStepDefinitopn extends Setup {

    private static final String ACTOR_NAME = "Administrador";
    private static final String USER = "Admin";
    private static final String PASSWORD = "admin123";
    private static final String NOMBRE_VACANTE = "Tecnico de Data Base";
    private static final String HIRING_MANAGER = "Cassidy Hope";
    private static final String NUMERO_VACANTES = "2";
    private static final String DESCRIPCION = "Apoyo del administrador de base de datos";
    private static final String COMENTARIO = "Datos cargados correctamente";
    private static final String CAUSA = "No se encuentra File.txt";
    private static final String ARCHIVO = "File.txt";


    //============================================================================//
    //============================================================================//

    @Given("el empleado administrativo se encuentra logueado en la web de OrangeHRM")
    public void elEmpleadoAdministrativoSeEncuentraLogueadoEnLaWebDeOrangeHRM() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(openLandingPage());
        theActorInTheSpotlight().attemptsTo(doLoginOrange().setUser(USER).setPassword(PASSWORD));
    }

    //============================================================================//
    //============================================================================//

    @When("el empleado quiere crear una nueva vacante")
    public void elEmpleadoQuiereCrearUnaNuevaVacante() {
        theActorInTheSpotlight().attemptsTo(
                fillFieldsVacancyNew()
                        .setVacancyName(NOMBRE_VACANTE)
                        .setHiringManager(HIRING_MANAGER)
                        .setNumbersOfPositions(NUMERO_VACANTES)
                        .setDescription(DESCRIPCION)
                        .setComment(COMENTARIO)
        );
    }

    //============================================================================//
    //============================================================================//

    @Then("el sistema deberia mostrar un mensaje Sucessfully saved.")
    public void elSistemaDeberiaMostrarUnMensajeSucessfullySaved() {
        validationData(FILE_NAME,ARCHIVO);
    }

    public void validationData (Target target, String message) {
        theActorInTheSpotlight().should(
                seeThat(vacancyNew().setTarget(target)
                        .setAssertionMassage(message)
                        .is(), equalTo(true))
                        .orComplainWith(ValidationLoginOrange.class, String.format(VALIDATION_DO_NOT_MATCH, CAUSA)));
    }
}
