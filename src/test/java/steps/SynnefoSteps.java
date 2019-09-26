package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;

public class SynnefoSteps {
    private WebDriver driver;

    @Before
    public void before() {
        ChromeOptions o = new ChromeOptions();
        o.setHeadless(true);
        o.addArguments("--no-sandbox");
        driver = new ChromeDriver(o);
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @When("The CorrelationTracking Github contributors page is open")
    public void theCorrelationTrackingGithubContributorsPageIsOpen() {
        driver.navigate().to("https://github.com/albumprinter/CorrelationTracking/graphs/contributors");
        wait7Seconds();
    }

    @When("The Synnefo Github contributors page is open")
    public void theSynnefoGithubContributorsPageIsOpen() {
        driver.navigate().to("https://github.com/albumprinter/junit-synnefo/graphs/contributors");
        wait7Seconds();
    }

    private void wait7Seconds() {
        // I have no idea how to wait for the loading to complete
        // For the demo project this does the trick anyway
        try { Thread.sleep(7000); }
        catch (Exception e) {}
    }

    @Then("There is (.*) in the contributors list")
    public void thereIsInTheContributorsList(String contributor) {
        String src = driver.getPageSource();
        if (!src.contains(contributor)) {
            throw new RuntimeException(contributor + " is not present on the page" + src);
        }
    }
}
