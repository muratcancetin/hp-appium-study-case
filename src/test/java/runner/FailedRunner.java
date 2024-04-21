package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "rerun:target/failed_scenarios.txt"
        },
        features = "@target/failed_scenarios.txt",
        glue = "stepDefinitions",
        dryRun = false
)
public class FailedRunner {

}
