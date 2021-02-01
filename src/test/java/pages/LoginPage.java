package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class LoginPage {
    public LoginPage open() {
        Selenide.open("/login");
        return this;

    }

    public LoginPage with(String email, String pass) {
        $("#emailId").setValue(email);
        $("input[type='password']").setValue(pass);
        $(byText("Entrar")).click();
        return this;
    }

    public SelenideElement alert() {
        return $(".alert span");
    }

    public String alertText() {
        return $(".alert span").text();
    }


    public void cleanSession() {
        executeJavaScript("localStorage.clear();");
    }

}
