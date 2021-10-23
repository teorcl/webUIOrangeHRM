package co.com.sofka.userinterfaces.loginorangehrm;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class LoginOrange extends PageObject {

    //==============================================================================//
    //======================ELEMENTOS DE ORANGE LOGIN===============================//
    public static final Target BTN_LOGIN = Target
            .the("boton loginorangehrm")
            .located(id("btnLogin"));

    //=========================================================================================//
    //=========================================================================================//
    //For fill elements.
    public static final Target USER = Target
            .the("user name")
            .located(id("txtUsername"));

    public static final Target PASSWORD = Target
            .the("Password")
            .located(id("txtPassword"));

    //=========================================================================================//
    //=========================================================================================//
    //For validations.
    public static final Target SPAN_MESSAGE = Target
            .the("span Message")
            .located(id("spanMessage"));


    public static final Target RECRUITMENT = Target
            .the("Recruitment")
            .located(xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b"));



}
