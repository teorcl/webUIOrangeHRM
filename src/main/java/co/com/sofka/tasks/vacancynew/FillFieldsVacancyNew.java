package co.com.sofka.tasks.vacancynew;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import static co.com.sofka.userinterfaces.loginorangehrm.LoginOrange.USER;
import static co.com.sofka.userinterfaces.vacancynew.VacancyNew.*;

public class FillFieldsVacancyNew implements Task {
    private String jobTiltle;
    private String vacancyName;
    private String hiringManager;
    private String numbersOfPositions;
    private String description;
    private String comment;
    private String ruta = System.getProperty("user.dir")+"\\src\\test\\resources\\File\\File.txt";

    public FillFieldsVacancyNew setJobTitle(String jobTiltle){
        this.jobTiltle = jobTiltle;
        return this;
    }

    public FillFieldsVacancyNew setVacancyName(String vacancyName){
        this.vacancyName = vacancyName;
        return this;
    }

    public FillFieldsVacancyNew setHiringManager(String hiringManager){
        this.hiringManager = hiringManager;
        return this;
    }

    public FillFieldsVacancyNew setNumbersOfPositions(String numbersOfPositions){
        this.numbersOfPositions = numbersOfPositions;
        return this;
    }

    public FillFieldsVacancyNew setDescription(String description){
        this.description = description;
        return this;
    }

    public FillFieldsVacancyNew setComment(String comment){
        this.comment = comment;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(MENU_RECRUITMENT),
                Click.on(MENU_RECRUITMENT),

                Scroll.to(VACANCIES),
                Click.on(VACANCIES),

                Scroll.to(BTN_ADD),
                Click.on(BTN_ADD),

                //LISTA DESPLEGABLE CON EL JOB TILTLE
                SelectFromOptions.byVisibleText("Database Administrator").from(JOB_TITLE),

                Scroll.to(VACANCY_NAME),
                Clear.field(VACANCY_NAME),
                Enter.theValue(this.vacancyName).into(VACANCY_NAME),

                Scroll.to(HIRING_MANAGER),
                Clear.field(HIRING_MANAGER),
                Enter.theValue(this.hiringManager).into(HIRING_MANAGER),

                Scroll.to(NUMBERS_OF_POSITIONS),
                Clear.field(NUMBERS_OF_POSITIONS),
                Enter.theValue(this.numbersOfPositions).into(NUMBERS_OF_POSITIONS),

                Scroll.to(DESCRIPTION),
                Clear.field(DESCRIPTION),
                Enter.theValue(this.description).into(DESCRIPTION),

                Scroll.to(BTN_SAVE),
                Click.on(BTN_SAVE),

                Scroll.to(BTN_ADD_ATTACHMENT),
                Click.on(BTN_ADD_ATTACHMENT),

                //=============================================//
                //=========IMPLEMENTAR EL UPLOAD===============//
                Enter.keyValues(ruta).into(BTN_SELECT_FILE),

                //COmentario final
                Scroll.to(COMMENT),
                Clear.field(COMMENT),
                Enter.theValue(this.comment).into(COMMENT),

                Scroll.to(BTN_UPLOAD),
                Click.on(BTN_UPLOAD)

                );
    }

    public static FillFieldsVacancyNew fillFieldsVacancyNew(){
        return new FillFieldsVacancyNew();
    }

}
