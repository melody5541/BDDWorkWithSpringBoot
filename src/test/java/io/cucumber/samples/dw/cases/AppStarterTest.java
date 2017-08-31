package io.cucumber.samples.dw.cases;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by stlv for developerworks article
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty",
                "html:target/html-report/",
                "json:target/json-report/dw.json"
        }
        , features = {"classpath:features"}
        , glue = {"io.cucumber.samples.dw.steps"}
        , tags = "@api"
)
@ContextConfiguration("classpath:cucumber.xml")
public class AppStarterTest {

}
