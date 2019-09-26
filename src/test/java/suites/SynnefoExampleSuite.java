package suites;

import albelli.junit.synnefo.api.*;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Synnefo.class)
@SynnefoOptions(
        threads = 10,
        runLevel = SynnefoRunLevel.SCENARIO,
        reportTargetDir = "build/synnefo",
        image = "aws/codebuild/standard:2.0",
        serviceRole = "arn:aws:iam::689887889323:role/AWS-CodeBuild-Service",
        bucketName = "689887889323-synnefo",

        cucumberOptions = @CucumberOptions(
                features = "classpath:features/",
                glue = "steps",
                tags = {"@regression", "not @excluded"},
                plugin = {
                        "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"
                },
                strict = true
        ))
public class SynnefoExampleSuite {
    @SynnefoBeforeAll
    public static void setUp() {
        System.out.println("I will run before any tests execute");
    }

    @SynnefoAfterAll
    public static void tearDown() {
        System.out.println("I will run after all of the tests execute");
    }
}