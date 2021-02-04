package steps;

import help.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MovieSteps extends BaseTest {

    @Given("Login com {string} e {string}")
    public void login_com_e(String email, String pass) {
        start();
        login
                .open()
                .with(email, pass);
    }

    @Given("que {string} é um novo filme")
    public void que_é_um_novo_filme(String movies) {
        movie.add();
        movie.create(movies);
    }

    @When("eu faço o cadastro desse filme")
    public void eu_faço_o_cadastro_desse_filme() {
        movie.register();
    }

    @Then("devo ver o novo filme na lista")
    public void devo_ver_o_novo_filme_na_lista() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
