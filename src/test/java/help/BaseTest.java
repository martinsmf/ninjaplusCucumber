package help;

import com.codeborne.selenide.Configuration;
import libis.DataBase;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MoviePage;
import pages.SideBar;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BaseTest {
    protected static LoginPage login;
    protected static SideBar side;
    protected static MoviePage movie;
    protected static DataBase db;

    //@BeforeMethod
    public void start() {

        Configuration.timeout = 10000;
        Configuration.browser = "Chrome";
        Configuration.baseUrl = "http://127.0.0.1:5000";
        login = new LoginPage();
        side = new SideBar();
        movie = new MoviePage();
        db = new DataBase();

    }

    public void thenAnd(){
            executeJavaScript("localStorage.clear();");
    }



}
