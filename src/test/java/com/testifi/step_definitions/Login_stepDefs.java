package com.testifi.step_definitions;

import com.testifi.utilities.ConfigurationReader;
import com.testifi.utilities.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static com.testifi.utilities.LoginUtils.*;

public class Login_stepDefs {
    WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

    @Given("User is on the Testifi website")
    public void user_is_on_the_testifi_website() {
        driver.get(ConfigurationReader.getProperty("URL"));

    }
    @Given("User should see Pets tab")
    public void user_should_see_pets_tab() {
    petDisplayed(driver);

    }
    @Given("User enters correct credentials and logs in")
    public void user_enters_correct_credentials_and_logs_in() {
        enterCredentials(ConfigurationReader.getProperty("validUsername"),
                ConfigurationReader.getProperty("validPassword"),driver);
        clickLogIn(driver);
    }
    @Then("User should see the Home, Pets, and Store tab")
    public void user_should_see_the_home_pets_and_store_tab() {
        loginState(driver);
        driver.close();
    }

    @Given("User enters incorrect credentials")
    public void user_enters_incorrect_credentials() {
        enterCredentials(ConfigurationReader.getProperty("InvalidUsername"),
                ConfigurationReader.getProperty("InvalidPassword"),driver);

    }
    @Given("User clicks the -LogIn- button")
    public void user_clicks_the_log_in_button() {
        clickLogIn(driver);
    }
    @Then("User should see the -Username or password are wrong- error message")
    public void user_should_see_the_username_or_password_are_wrong_error_message() throws Exception {
        checkErrorMSG(driver);
        driver.close();
    }
}
