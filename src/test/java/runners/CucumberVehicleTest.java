package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/feature"},
        glue = {"com.richard.cordbyte.steps", "com.richard.cordbyte.hooks"},
        tags = "@Vehicle",
        plugin = {"pretty", "html:target/reports", "json:target/reports/cucumber.json", "junit:target/reports/cucumber.xml"}
        )
public class CucumberVehicleTest {

}
