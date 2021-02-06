package steps;

import help.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static org.testng.Assert.assertEquals;


public class LoginSteps extends BaseTest {

    @When("eu faco login com {string} e {string}")
    public void eu_faco_login_com_e(String email, String pass) {
        start();
        login
                .open()
                .with(email, pass);
    }

    @Then("devo ver {string} na área logada")
    public void devo_ver_na_área_logada(String user) {
        side.loggedUser().shouldHave(text(user));
        login.cleanSession();
    }

    @Then("devo ver a mensagem de alerta {string}")
    public void devo_ver_a_mensagem_de_alerta(String alert) {
        login.alert().shouldHave(text(alert));
        assertEquals(login.alertText(), alert);
        thenAnd();
    }
}
