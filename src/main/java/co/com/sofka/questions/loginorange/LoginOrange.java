package co.com.sofka.questions.loginorange;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.sofka.userinterfaces.loginorangehrm.LoginOrange.*;

public class LoginOrange implements Question<Boolean> {

    private String assertionmessage;
    private Target target;
    public LoginOrange AssertionMessage(String assertionmessage){
        this.assertionmessage = assertionmessage;
        return this;
    }

    public LoginOrange Target(String target) {
        if(target=="1") this.target =SPAN_MESSAGE;
        if(target=="2") this.target = RECRUITMENT;

        return this;
    }


    public LoginOrange is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (target.resolveFor(actor).containsOnlyText(assertionmessage));
    }

    public static LoginOrange loginOrange(){
        return new LoginOrange();
    }
}
