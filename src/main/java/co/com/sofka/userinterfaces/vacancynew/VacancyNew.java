package co.com.sofka.userinterfaces.vacancynew;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class VacancyNew extends PageObject {

    public static final Target MENU_RECRUITMENT = Target.the("recruitmentMenu").
            located(id("menu_recruitment_viewRecruitmentModule"));

    public static final Target VACANCIES = Target.the("Vacancies").
            located(id("menu_recruitment_viewJobVacancy"));

    public static final Target BTN_ADD = Target.the("btnAdd").
            located(id("btnAdd"));

    //Lista desplegable
    public static final Target JOB_TITLE = Target.the("jobTitle").
            located(id("addJobVacancy_jobTitle"));

    public static final Target VACANCY_NAME = Target.the("vacancyName").
            located(id("addJobVacancy_name"));

    public static final Target HIRING_MANAGER = Target.the("hiringManagment").
            located(id("addJobVacancy_hiringManager"));

    public static final Target NUMBERS_OF_POSITIONS = Target.the("numbersOfPositions").
            located(id("addJobVacancy_noOfPositions"));

    public static final Target DESCRIPTION = Target.the("description").
            located(id("addJobVacancy_description"));

    public static final Target BTN_SAVE = Target.the("btnSave").
            located(id("btnSave"));

    public static final Target BTN_ADD_ATTACHMENT = Target.the("btnAddAttachment").
            located(id("btnAddAttachment"));

    public static final Target BTN_SELECT_FILE = Target.the("selectFile").
            located(id("recruitmentAttachment_ufile"));

    public static final Target COMMENT = Target.the("comment").
            located(id("recruitmentAttachment_comment"));

    //Este elemento en caso de no saber como usar el upload de serenity
    public static final Target BTN_UPLOAD = Target.the("btnSaveUpload").
            located(id("btnSaveAttachment"));

    //=====================================================================================//
    //==================================For_Assertion=====================================//
    public static final Target FILE_NAME = Target.the("fileName").
            located(xpath("//*[@id=\"tblAttachments\"]/tbody/tr/td[2]/a"));


}
