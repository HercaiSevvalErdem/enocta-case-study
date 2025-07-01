package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        dryRun = false,
        monochrome = true
        // tags = "@smoke" // ilk aşamada gerekmez, sonra filtrelemede kullanılabilir
)
public class Runner {
}
