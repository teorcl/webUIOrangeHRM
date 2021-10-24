package co.com.sofka.runner.loginorange;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/loginorangehrm/loginorangehrm.feature"},
        glue = {"co.com.sofka.stepdefinition.loginorangehrm"},
        tags = {"not @ignore"}
)
public class LoginOrangeRunner {
}
