package br.com.alura.leilao.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class LeilaoDaoTest {

	private LeilaoDao dao;
	private EntityManager em;

	@BeforeEach
	public void BeforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new LeilaoDao(em);
		em.getTransaction().begin();
	}

	@AfterEach
	public void AfterEach() {
		em.getTransaction().rollback();
	}

	@Test
	void deveriaCadastrarUmLeilao() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("Fulano")
				.comEmail("fulano@gmail.com")
				.comSenha("1222")
				.criar();
		em.persist(usuario);
		Leilao leilao = new LeilaoBuilder()
				.comNome("Mochila")
				.comValorInicial("500")
				.comData(LocalDate.now())
				.comUsuario(usuario)
				.criar();
		dao.salvar(leilao);
		Leilao salvo = dao.buscarPorId(leilao.getId());
		Assert.assertNotNull(salvo);
	}

	@Test
	void deveriaDarUpdateEmUmLeilao() {
		Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), criarUsuario());
		leilao = dao.salvar(leilao);
		leilao.setNome("Celular");
		leilao.setValorInicial(new BigDecimal("400"));
		leilao = dao.salvar(leilao);

		Leilao salvo = dao.buscarPorId(leilao.getId());
		Assert.assertEquals("Celular", salvo.getNome());
		Assert.assertEquals(new BigDecimal("400"), salvo.getValorInicial());
	}

	
	/** 
	 * @return Usuario
	 */
	private Usuario criarUsuario() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		em.persist(usuario);
		return usuario;
	}
}
