package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition1 {

    WebDriver driver;

    // =====================================================
    // COMMON STEPS - VALID LOGIN AND INVALID USERNAME
    // =====================================================

    @Given("User should open Chrome Browser")
    public void user_should_open_chrome_browser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("User should Enter url in Browser")
    public void user_should_enter_url_in_browser() {

        driver.get(
            "https://practicetestautomation.com/practice-test-login/"
        );
    }

    @When("User should Navigate Home Page")
    public void user_should_navigate_home_page() {

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
            currentUrl.contains("practicetestautomation.com"),
            "Practice Test Automation page is not opened"
        );
    }

    // =====================================================
    // VALID LOGIN
    // =====================================================

    @When("Enter Username and Password in Edit Box")
    public void enter_username_and_password_in_edit_box() {

        driver.findElement(By.id("username"))
              .sendKeys("student");

        driver.findElement(By.name("password"))
              .sendKeys("Password123");
    }

    // =====================================================
    // INVALID USERNAME
    // =====================================================

    @When("Enter Invalid Username and Valid Password in Edit Box")
    public void enter_invalid_username_and_valid_password_in_edit_box() {

        driver.findElement(By.id("username"))
              .sendKeys("incorrectUser");

        driver.findElement(By.name("password"))
              .sendKeys("Password123");
    }

    // =====================================================
    // INVALID PASSWORD - OLD STYLE
    // =====================================================

    @When("Enter Valid Username and Invalid Password in Edit Box")
    public void enter_valid_username_and_invalid_password_in_edit_box() {

        driver.findElement(By.id("username"))
              .sendKeys("student");

        driver.findElement(By.name("password"))
              .sendKeys("incorrectPassword");
    }

    // =====================================================
    // LOGIN BUTTON - OLD STYLE
    // =====================================================

    @When("Click On Login PushButton")
    public void click_on_login_pushbutton() {

        driver.findElement(By.cssSelector("button#submit"))
              .click();
    }

    // =====================================================
    // VALID LOGIN VERIFICATION
    // =====================================================

    @Then("Message displayed Login Successfully")
    public void message_displayed_login_successfully() {

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
            currentUrl.contains("logged-in-successfully"),
            "Login was not successful"
        );

        String message =
            driver.findElement(By.tagName("strong")).getText();

        System.out.println(
            "Login Success URL: " + currentUrl
        );

        System.out.println(
            "Success Message: " + message
        );

        Assert.assertTrue(
            message.contains("successfully logged in"),
            "Success message was not displayed"
        );

        Assert.assertTrue(
            driver.findElement(By.linkText("Log out")).isDisplayed(),
            "Log out button is not displayed"
        );

        driver.quit();
    }

    // =====================================================
    // COMMON ERROR MESSAGE
    // =====================================================

    @Then("Error Message should be displayed")
    public void error_message_should_be_displayed() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement errorMessage = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("error")
            )
        );

        Assert.assertTrue(
            errorMessage.isDisplayed(),
            "Error message is not displayed"
        );

        System.out.println(
            "Error Message: " + errorMessage.getText()
        );
    }

    // =====================================================
    // INVALID USERNAME VERIFICATION
    // =====================================================

    @Then("Verify Invalid Username Error Message")
    public void verify_invalid_username_error_message() {

        String errorMessage =
            driver.findElement(By.id("error")).getText();

        System.out.println(
            "Invalid Username Error Message: "
            + errorMessage
        );

        Assert.assertEquals(
            errorMessage,
            "Your username is invalid!",
            "Invalid username error message is incorrect"
        );

        driver.quit();
    }

    // =====================================================
    // INVALID PASSWORD VERIFICATION - OLD STYLE
    // =====================================================

    @Then("Verify Invalid Password Error Message")
    public void verify_invalid_password_error_message() {

        String errorMessage =
            driver.findElement(By.id("error")).getText();

        System.out.println(
            "Invalid Password Error Message: "
            + errorMessage
        );

        Assert.assertEquals(
            errorMessage,
            "Your password is invalid!",
            "Invalid password error message is incorrect"
        );

        driver.quit();
    }

    // =====================================================
    // INVALID PASSWORD FEATURE - NEW STYLE
    // =====================================================

    @Given("User should Launch Chrome browser")
    public void launch_chrome_browser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("User should Navigate to url {string}")
    public void navigate_to_url(String url) {

        driver.get(url);
    }

    @Then("Enter username {string}")
    public void enter_username(String username) {

        driver.findElement(By.id("username"))
              .sendKeys(username);
    }

    @Then("Enter password {string}")
    public void enter_password(String password) {

        driver.findElement(By.id("password"))
              .sendKeys(password);
    }

    @Then("Click {string} button")
    public void click_button(String button) {

        driver.findElement(By.id("submit"))
              .click();
    }

    @Then("Verify error message is displayed")
    public void verify_error_message_is_displayed() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement errorMessage = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("error")
            )
        );

        Assert.assertTrue(
            errorMessage.isDisplayed(),
            "Error message is not displayed"
        );

        System.out.println(
            "Error Message: " + errorMessage.getText()
        );
    }

    @Then("Verify error message text is {string}")
    public void verify_error_message_text_is(
            String expectedMessage) {

        String actualMessage =
            driver.findElement(By.id("error")).getText();

        System.out.println(
            "Expected Error: " + expectedMessage
        );

        System.out.println(
            "Actual Error: " + actualMessage
        );

        Assert.assertEquals(
            actualMessage,
            expectedMessage,
            "Error message text is incorrect"
        );

        driver.quit();
    }
}