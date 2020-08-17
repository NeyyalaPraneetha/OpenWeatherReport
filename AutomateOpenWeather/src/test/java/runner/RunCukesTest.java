package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"StepImplementation", "utilities"},
        monochrome = true,
//        tags = "@Temp1",
        plugin = {"pretty","json:target/jsonReport/cucumber.json"}
)
public class RunCukesTest {

}