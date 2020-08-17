package Cucumbertests;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/main/resources/OpenWeatherMap.feature"},
        glue={"src/main/java/StepImplementation/Stepdefs.java", "src/main/java/utilities/driverfactory.java"},
        monochrome = true,
        plugin = {"pretty","html:target/HTMLReport", "json:target/cucumber.json"}
)
public class testRunner {

}
