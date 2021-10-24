package co.com.sofka.questions.vacancynew;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class VacancyNew implements Question<Boolean> {

    private String assertionmessage;
    private Target target;

    public VacancyNew setTarget(Target target){
        this.target = target;
        return this;
    }

    public VacancyNew setAssertionMassage(String assertionmessage){
        this.assertionmessage = assertionmessage;
        return this;
    }

    public VacancyNew is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return (target.resolveFor(actor).containsOnlyText(assertionmessage));
    }

    public static VacancyNew vacancyNew(){
        return new VacancyNew();
    }
}
