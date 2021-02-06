package steps;

import help.BaseTest;
import help.Propet;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


public class MovieSteps extends BaseTest {

    Propet prop = new Propet();
    BaseTest bt = new BaseTest();

    @Before
    public void Start(){
        start();
    }

    @Given("Login com {string} e {string}")
    public void login_com_e(String email, String pass) {
        login
                .open()
                .with(email, pass);
    }

    @Given("que {string} é um novo filme")
    public void que_é_um_novo_filme(String movies) {
        db.deleteMovie(prop.propertis(movies, ".title"));
        movie.add();
        movie.create(movies);

    }

    @When("eu faço o cadastro desse filme")
    public void eu_faço_o_cadastro_desse_filme() {
        movie.register();
    }

    @Then("devo ver o novo filme {string} na lista")
    public void devo_ver_o_novo_filme_na_lista(String movies) {
        movie.item().findBy(text(prop.propertis(movies, ".title"))).shouldBe(visible);
    }

    @Then("devo ver a notificação {string}")
    public void devo_ver_a_notificação(String text) {
        movie.alert().equals(text);
    }

    @After
    public void end(){
        thenAnd();
    }

}
