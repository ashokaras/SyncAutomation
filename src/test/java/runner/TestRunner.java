package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        dryRun = true,
        glue = "steps",
        //tags = "@customerName",
        plugin = {"pretty","html:output/html-output.html"}
)
public class TestRunner {
}
