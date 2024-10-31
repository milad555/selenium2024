package support;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/nopCategory.feature")
@SelectClasspathResource("features/quote.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "definitions,support")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@predefined")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/report.html, json:target/report.json")
//@Execution(ExecutionMode.CONCURRENT)
public class RunCucumberTest {

}