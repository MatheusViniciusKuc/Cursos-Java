package br.com.alura.leilao.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

@Repository
public class LeilaoDao {

	private EntityManager em;

	@Autowired
	public LeilaoDao(EntityManager em) {
		this.em = em;
	}

	
	/** 
	 * @param leilao
	 * @return Leilao
	 */
	public Leilao salvar(Leilao leilao) {
		return em.merge(leilao);
	}

	
	/** 
	 * @param id
	 * @return Leilao
	 */
	public Leilao buscarPorId(Long id) {
		return em.find(Leilao.class, id);
	}

	
	/** 
	 * @return List<Leilao>
	 */
	public List<Leilao> buscarTodos() {
		return em.createQuery("SELECT l FROM Leilao l", Leilao.class)
				.getResultList();
	}

	
	/** 
	 * @param inicio
	 * @param fim
	 * @return List<Leilao>
	 */
	public List<Leilao> buscarLeiloesDoPeriodo(LocalDate inicio, LocalDate fim) {
		return em.createQuery("SELECT l FROM Leilao l WHERE l.dataAbertura BETWEEN :inicio AND :fim", Leilao.class)
				.setParameter("inicio", inicio)
				.setParameter("fim", inicio)
				.getResultList();
	}

	
	/** 
	 * @param usuario
	 * @return List<Leilao>
	 */
	public List<Leilao> buscarLeiloesDoUsuario(Usuario usuario) {
		return em.createQuery("SELECT l FROM Leilao l WHERE l.usuario = :usuario", Leilao.class)
				.setParameter("usuario", usuario)
				.getResultList();
	}

}
