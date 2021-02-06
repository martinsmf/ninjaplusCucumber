package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import help.Propet;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MoviePage {

    Propet prop = new Propet();



    public MoviePage add() {
        $(".movie-add").click();
        return this;
    }

    public MoviePage search(String vaule){
        $("input[placeholder^=Pesquisar]").setValue(vaule);
        $("#search-movie").click();
        return this;
    }

    public MoviePage create(String movie) {
        // Carregando massa de testes

        //incerindo dados
        $("input[name=title]").setValue(prop.propertis(movie, ".title"));
        this.selectStatus(movie);
        $("input[name=year]").setValue(prop.propertis(movie , ".year"));
        String release_date = prop.propertis(movie, ".release_date");
        $("input[placeholder$='estréia']").setValue(release_date).sendKeys(Keys.ENTER);
        this.inputCast(movie);
        $("textarea[name=overview]").setValue(prop.propertis(movie, ".overview"));
        this.upLoad(movie);
        return this;
    }

    public void register(){
        $("#create-movie").click();
    }

    public ElementsCollection item(){
       return  $$("table tbody tr");
    }

    private void selectStatus(String movie) {
        $("input[placeholder=Status]").click();
        $$("ul li span").findBy(text(prop.propertis(movie, ".status"))).click();
    }

    private void inputCast(String movie) {
        String cast = prop.propertis(movie, ".cast");
        String[] array = cast.split(",");
        SelenideElement element = $(".cast");
        for (String actor : array) {
            element.sendKeys(actor);
            element.sendKeys(Keys.TAB);
        }
    }

    private void upLoad(String movie){
        File cover = new File(this.coverPath() + prop.propertis(movie, ".cover"));
        executeJavaScript("document.getElementById('upcover').classList.remove('el-upload__input');");
        $("#upcover").uploadFile(cover);
        executeJavaScript("document.getElementById('upcover').classList.add('el-upload__input');");
    }

    private String coverPath(){
        String executionPath =  System.getProperty("user.dir");
        String os = System.getProperty("os.name");
        String target;
        if(os.contains("Windows")){
            target = executionPath + "\\src\\main\\resources\\covers\\";
        }else {
            target = executionPath + "/src/main/resources/covers/";
        }
        return target;
    }




}
