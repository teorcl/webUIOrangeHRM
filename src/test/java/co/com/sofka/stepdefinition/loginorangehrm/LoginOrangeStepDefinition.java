package co.com.sofka.stepdefinition.loginorangehrm;

import co.com.sofka.exceptions.login.ValidationLoginOrange;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.login.ValidationLoginOrange.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.loginorange.LoginOrange.loginOrange;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.loginorange.DoLoginOrange.doLoginOrange;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginOrangeStepDefinition extends Setup {

    private static final String ACTOR_NAME = "Administrador";
    private static final String USER = "Admin";
    private static final String PASSWORD = "admin123";
    private static final String MSN_FALLO = "Falló inicio de sesión";
    private static final String RECRUITMENT_ASSERTION = "Recruitment";
    private static final String EMPTY_ASSERTION = "Username cannot be empty";
    private static final String CREDENTIAL_ASSERTION = "Invalid credentials";

    private DataTable dataToValidate;

    //=================================================================//
    //===================LOGIN-SUCCESSFULL============================//
    @Given("quiero logearme en el sitio web de OrangeHRM")
    public void quieroLogearmeEnElSitioWebDeOrangeHRM() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(openLandingPage());
    }

    @When("ingreso user and password correctas")
    public void ingresoUserAndPasswordCorrectas() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(doLoginOrange().setUser(USER).setPassword(PASSWORD));
    }

    @Then("deberia iniciar sesion")
    public void deberiaIniciarSesion() {
        validationData("2", RECRUITMENT_ASSERTION);
    }

    //=================================================================//
    //=======================LOGIN-FALLIDO============================//
    @When("ingreso credenciales no validas")
    public void ingresoCredencialesNoValidas() {

    }
    @When("digite")
    public void digite(io.cucumber.datatable.DataTable dataTable) {
        dataToValidate = dataTable;

        if(dataTable.row(0).get(1)==null && dataTable.row(1).get(1)==null) theActorInTheSpotlight().attemptsTo(doLoginOrange().setUser("").setPassword(""));
        if(dataTable.row(0).get(1)!=null && dataTable.row(1).get(1)!=null) {
            theActorInTheSpotlight().attemptsTo(doLoginOrange()
                    .setUser(dataTable.row(0).get(1))
                    .setPassword(dataTable.row(1).get(1)));

        }
    }
    @Then("el sistema deberia arrojar una advertencia")
    public void elSistemaDeberiaArrojarUnaAdvertencia() {
        if(dataToValidate.row(0).get(1)==null && dataToValidate.row(1).get(1)==null) validationData("1",EMPTY_ASSERTION);

        if(dataToValidate.row(0).get(1)!=null && dataToValidate.row(1).get(1)!=null) validationData("1",CREDENTIAL_ASSERTION);

    }

    public void validationData (String target, String message) {
        theActorInTheSpotlight().should(
                seeThat(loginOrange().Target(target).AssertionMessage(message).is(), equalTo(true))
                        .orComplainWith(ValidationLoginOrange.class, String.format(VALIDATION_DO_NOT_MATCH, MSN_FALLO)));
    }



}
