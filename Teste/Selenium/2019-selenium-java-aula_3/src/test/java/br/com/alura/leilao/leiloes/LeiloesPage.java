package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class LeiloesPage {

    private WebDriver browser;

    public LeiloesPage(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = browser;
    }

    public void fechar() {
        this.browser.quit();
    }

    public CadastroLeilaoPage carregarFormulario() {
        this.browser.navigate().to("http://localhost:8080/leiloes/new");
        return new CadastroLeilaoPage(browser);
    }

    //public boolean isLeilaoCadastrado(String nome, String valor, String hoje) {
    //    
    //}

}
