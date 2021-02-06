package steps;

import com.codeborne.selenide.ElementsCollection;
import help.BaseTest;
import help.Propet;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends BaseTest {

    Propet prop = new Propet();
    ElementsCollection filme;

    @When("faço a busca do filme {string}")
    public void faço_a_busca_do_filme(String movies) {
        db.insertMovies();
        filme = movie.search(movies).item();

    }

    @Then("devo ver apenas o filme {string} na lista")
    public void devo_ver_apenas_o_filme_na_lista(String movies) {
        filme.equals(movies);
        filme.shouldHaveSize(1);
        thenAnd();
    }

}


