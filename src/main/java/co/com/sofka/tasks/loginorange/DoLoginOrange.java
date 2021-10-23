package co.com.sofka.tasks.loginorange;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterfaces.loginorangehrm.LoginOrange.*;

public class DoLoginOrange implements Task {

    private String user;
    private String password;

    public DoLoginOrange setUser(String user){
        this.user = user;
        return this;
    }

    public DoLoginOrange setPassword(String password){
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(USER),
                Clear.field(USER),
                Enter.theValue(this.user).into(USER),

                Scroll.to(PASSWORD),
                Clear.field(PASSWORD),
                Enter.theValue(this.password).into(PASSWORD),

                Scroll.to(BTN_LOGIN),
                Click.on(BTN_LOGIN)

        );
    }

    public static DoLoginOrange doLoginOrange(){
        return new DoLoginOrange();
    }
}
