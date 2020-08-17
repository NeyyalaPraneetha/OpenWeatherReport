package Cucumbertests;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/main/resources/features/"},
        glue={"StepImplementation","utilities"},
        monochrome = true,
        tags = "@Temp1",
        plugin = {"pretty","html:target/htmlreport.html", "json:target/cucumber.json"}
)
public class testRunner {

}
