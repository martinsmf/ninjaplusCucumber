package pages;

import com.codeborne.selenide.SelenideElement;
import models.MovieModel;
import org.openqa.selenium.Keys;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
        // Carregando massa de testes
        try {
            prop.load(inputFile);
        } catch (Exception ex) {
            System.out.println("Erro ao carregar arquivo ymal => " + ex.getMessage());
        }

        System.out.println();
        //incerindo dados
        $("input[name=title]").setValue(prop.getProperty(movie + ".title"));
        this.selectStatus(movie);
        $("input[placeholder$='estréia']").setValue(prop.getProperty(movie + ".release_date")).sendKeys(Keys.ENTER);
        this.inputCast(movie);
        $("textarea[name=overview]").setValue(prop.getProperty(movie + ".overview"));
        return this;
    }

    private void selectStatus(String movie) {
        $("input[placeholder=Status]").click();
        $$("ul li span").findBy(text(prop.getProperty(movie + ".status"))).click();
    }

    private void inputCast(String movie) {
        String cast = prop.getProperty(movie + ".cast");
        String[] array = cast.split(",");
        System.out.println(array);
        SelenideElement element = $(".cast");
        for (String actor : array) {
            element.sendKeys(actor);
            element.sendKeys(Keys.TAB);
        }
    }


}
