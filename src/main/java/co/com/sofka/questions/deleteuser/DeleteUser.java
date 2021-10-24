package co.com.sofka.questions.deleteuser;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class DeleteUser implements Question<Boolean> {

    private Target target;
    private String username;

    public DeleteUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public DeleteUser setTarget(Target target) {
        this.target = target;
        return this;
    }

    public DeleteUser is(){
        return this;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        return (target.resolveFor(actor).containsOnlyText(username));
    }


    public static DeleteUser wasDelete(){
        return new DeleteUser();
    }

}
