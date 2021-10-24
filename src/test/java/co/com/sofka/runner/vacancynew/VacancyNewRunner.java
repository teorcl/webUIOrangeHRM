package co.com.sofka.runner.vacancynew;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/vacancynew/vacancynew.feature"},
        glue = {"co.com.sofka.stepdefinition.vacancynew"},
        tags = {"not @ignore"}
)

public class VacancyNewRunner {
}
