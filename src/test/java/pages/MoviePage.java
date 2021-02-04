package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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
        //incerindo dados
        $("input[name=title]").setValue(prop.getProperty(movie + ".title"));
        this.selectStatus(movie);
        $("input[name=year]").setValue(prop.getProperty(movie + ".year"));
        String release_date = prop.getProperty(movie + ".release_date");
        $("input[placeholder$='estréia']").setValue(release_date).sendKeys(Keys.ENTER);
        this.inputCast(movie);
        $("textarea[name=overview]").setValue(prop.getProperty(movie + ".overview"));
        this.upLoad(movie);
        return this;
    }

    public void register(){
        $("#create-movie").click();
    }

    public MoviePage listMovie(String movie){
        $$("table tbody tr");
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

    private void upLoad(String movie){
        File cover = new File(this.coverPath() + prop.getProperty(movie + ".cover"));
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
