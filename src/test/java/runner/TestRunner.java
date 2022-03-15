package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        dryRun = false,
        glue = "steps",
        tags = "@customerName"
)
public class TestRunner {
}
