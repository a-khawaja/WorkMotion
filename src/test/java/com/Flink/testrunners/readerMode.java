package com.Flink.testrunners;

import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions
        (features = {"src/test/resources"},
                glue = "com/Flink/stepdefs",
                tags = {"@MoisturizerPurchasing"},
                plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
                        "json:TestReport/cucumber-reports/CucumberTestReport.json",
                        "rerun:TestReport/cucumber-reports/rerun.txt"}
        )

public class readerMode {

    private TestNGCucumberRunner testRunner;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        testRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Flink test", dataProvider = "features")
    public void test(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cFeature) throws Throwable {
        testRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider(name = "features")
    public Object[][] getFeatures() {
        return testRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void writeExtentReport() {
        testRunner.finish();
    }

}
