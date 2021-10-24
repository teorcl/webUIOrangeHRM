package co.com.sofka.runner.deleteuser;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/deleteuser/deleteuser.feature"},
        glue = {"co.com.sofka.stepdefinition.deleteuser"},
        tags = {"not @ignore"}
)

public class DeleteUserRunner {
}
