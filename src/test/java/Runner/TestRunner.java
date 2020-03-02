package Runner;

        import io.cucumber.testng.AbstractTestNGCucumberTests;
        import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ={"src/test/java/features"},plugin = {"html: target/site/cucumber-pretty"},
        glue = "Steps",strict = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
