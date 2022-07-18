package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private static final String URL_LOGIN = "http://localhost:8080/leiloes/login";
    private WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver (2)");
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.browser.quit();
    }

    public void preencherFormularioDeLogin(String username, String password) {
        this.browser.findElement(By.id("username")).sendKeys(username);
        this.browser.findElement(By.id("password")).sendKeys(password);
    }

    public void efetuaLogin() {
        this.browser.findElement(By.id("login-form")).submit();
    }

    public boolean isPaginaDeLogin(String url) {
        return browser.getCurrentUrl().equals(URL_LOGIN+url);
    }

    public Object getNomeUsuarioLogado() {
        try {
            return browser.findElement(By.id("pessoaLogada")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }

    }

    public void navegaPara(String string) {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }
}
