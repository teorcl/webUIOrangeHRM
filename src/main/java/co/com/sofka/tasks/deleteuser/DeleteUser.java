package co.com.sofka.tasks.deleteuser;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;


import static co.com.sofka.userinterfaces.deleteuser.DeleteUser.*;
import static co.com.sofka.util.Gender.*;

public class DeleteUser implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ADMIN_MENU),
                Click.on(ADMIN_MENU),

                Scroll.to(USER_MANAGEMENT),
                Click.on(USER_MANAGEMENT),

                Scroll.to(COL_USERNAME),
                Click.on(COL_USERNAME),
                Click.on(COL_USERNAME),

                /*Check.whether(ADMIN.getValue().equals("Admin"))
                        .andIfSo(
                                Scroll.to(CHK_SELECT_ADMIN),
                                Click.on(CHK_SELECT_ADMIN)
                        )
                        .otherwise(
                                Check.whether(FEMALE.getValue().equals(gender))
                                        .andIfSo(
                                                Scroll.to(GENDER_FEMALE),
                                                Click.on(GENDER_FEMALE)
                                        )
                                        .otherwise(
                                                Scroll.to(GENDER_OTHER),
                                                Click.on(GENDER_OTHER)
                                        )
                        ),*/
                Scroll.to(CHK_SELECT_USER),
                Click.on(CHK_SELECT_USER),



                Scroll.to(BTN_DELETE),
                Click.on(BTN_DELETE),

                Scroll.to(BTN_OK),
                Click.on(BTN_OK),

                Scroll.to(COL_USERNAME),
                Click.on(COL_USERNAME),
                Click.on(COL_USERNAME)
        );
    }

    public static DeleteUser deleteUser(){
        return new DeleteUser();
    }

}
