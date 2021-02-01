package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoviePage {

    Properties prop = new Properties();
    InputStream inputFile = getClass().getClassLoader().getResourceAsStream("movies.properties");


    public MoviePage add() {
        $(".movie-add").click();
        return this;
    }

    public MoviePage create(String movie) {
        //Carregando massa de testes
        try {
            prop.load(inputFile);
        } catch (Exception ex) {
            System.out.println("Erro ao carregar arquivo ymal => " + ex.getMessage());
        }
        System.out.println(inputFile);
        //incerindo dados
        $("input[name=title]").setValue(prop.getProperty(movie + ".title"));
        this.selectStatus(movie);
        this.inputCast(movie);
        return this;
    }

    private void selectStatus(String movie){
        $("input[placeholder=Status]").click();
        $$("ul li span").findBy(text(prop.getProperty(movie + ".status"))).click();
    }

    private void inputCast(String movie){
        List<String> cast = Arrays.asList(prop.getProperty(movie + ".cast"));
        System.out.println(cast);
        SelenideElement element = $(".cast");
        for(String actor: cast){
            element.sendKeys(actor);
            element.sendKeys(Keys.TAB);
        }
    }

}
