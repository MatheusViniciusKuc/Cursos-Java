package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDoLogin;

    @BeforeEach
    public void beforeEach() {
        this.paginaDoLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaDoLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        this.paginaDoLogin.preencherFormularioDeLogin("fulano" , "pass");
        this.paginaDoLogin.efetuaLogin();

        Assert.assertFalse(this.paginaDoLogin.isPaginaDeLogin(""));
        Assert.assertEquals("fulano", this.paginaDoLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        this.paginaDoLogin.preencherFormularioDeLogin("invalido" , "95451");
        this.paginaDoLogin.efetuaLogin();

        Assert.assertTrue(this.paginaDoLogin.isPaginaDeLogin("?error"));
        Assert.assertNull("fulano", this.paginaDoLogin.getNomeUsuarioLogado());
        Assert.assertTrue(this.paginaDoLogin.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        this.paginaDoLogin.navegaPara("http://localhost:8080/leiloes/2");
        Assert.assertTrue(this.paginaDoLogin.isPaginaDeLogin(""));
        Assert.assertFalse(this.paginaDoLogin.contemTexto("Dados do Leilão"));
    }
}
