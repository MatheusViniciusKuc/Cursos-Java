package br.com.alura.leilao.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Leilao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@DecimalMin(value = "0.1")
	private BigDecimal valorInicial;

	@OneToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	@NotNull
	private LocalDate dataAbertura;

	@OneToMany(mappedBy = "leilao")
	private List<Lance> lances = new ArrayList<>();

	@Deprecated
	public Leilao() {
	}

	public Leilao(@NotNull @NotBlank String nome) {
		this.nome = nome;
	}

	public Leilao(@NotBlank String nome, @NotNull @DecimalMin("0.1") BigDecimal valorInicial, @NotNull LocalDate dataAbertura) {
		this.nome = nome;
		this.valorInicial = valorInicial;
		this.dataAbertura = dataAbertura;
	}

	public Leilao(@NotNull @NotBlank String nome, @NotNull @DecimalMin("0.1") BigDecimal valorInicial, @NotNull Usuario usuario) {
		this.nome = nome;
		this.valorInicial = valorInicial;
		this.usuario = usuario;
		this.dataAbertura = LocalDate.now();
	}

	public Leilao(@NotNull @NotBlank String nome, @NotNull @DecimalMin("0.1") BigDecimal valorInicial, @NotNull LocalDate data, @NotNull Usuario usuario) {
		this.nome = nome;
		this.valorInicial = valorInicial;
		this.usuario = usuario;
		this.dataAbertura = data;
	}

	
	/** 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	
	/** 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/** 
	 * @param dataAbertura
	 */
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	
	/** 
	 * @return LocalDate
	 */
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	
	/** 
	 * @return Date
	 */
	public Date getDataAberturaDate() {
		return java.util.Date.from(this.dataAbertura.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	
	/** 
	 * @return boolean
	 */
	public boolean isAberto() {
		LocalDate hoje = LocalDate.now();
		return hoje.isAfter(this.dataAbertura) || hoje.isEqual(dataAbertura);
	}

	
	/** 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/** 
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	
	/** 
	 * @param valorInicial
	 */
	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}

	
	/** 
	 * @return BigDecimal
	 */
	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	
	/** 
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	/** 
	 * @return Usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	
	/** 
	 * @param lances
	 */
	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	
	/** 
	 * @param lanceAtual
	 * @return boolean
	 */
	public boolean propoe(Lance lanceAtual) {
		if (this.estaSemLances() || ehUmLanceValido(lanceAtual)) {
			adicionarLance(lanceAtual);
			return true;
		}
		return false;
	}

	
	/** 
	 * @param lance
	 */
	private void adicionarLance(Lance lance) {
		lances.add(lance);
		lance.setLeilao(this);
	}

	
	/** 
	 * @param lance
	 * @return boolean
	 */
	private boolean ehUmLanceValido(Lance lance) {
		return valorEhMaior(lance, ultimoLanceDado()) && oUltimoUsuarioNaoEhOMesmoDo(lance)
				&& totalDeLancesDoUsuarioEhMenorIgual5(lance.getUsuario());
	}

	
	/** 
	 * @param lance
	 * @param ultimoLanceDado
	 * @return boolean
	 */
	private boolean valorEhMaior(Lance lance, Lance ultimoLanceDado) {
		return lance.getValor().compareTo(ultimoLanceDado.getValor()) > 0;
	}

	
	/** 
	 * @param usuario
	 * @return boolean
	 */
	private boolean totalDeLancesDoUsuarioEhMenorIgual5(Usuario usuario) {
		int totalDeLances = qtdDeLancesDo(usuario);
		return totalDeLances <= 5;
	}

	
	/** 
	 * @param lance
	 * @return boolean
	 */
	private boolean oUltimoUsuarioNaoEhOMesmoDo(Lance lance) {
		Usuario ultimoUsuarioQueDeuLance = ultimoLanceDado().getUsuario();
		return !ultimoUsuarioQueDeuLance.equals(lance.getUsuario());
	}

	
	/** 
	 * @param usuario
	 * @return int
	 */
	private int qtdDeLancesDo(Usuario usuario) {
		int total = 0;
		for (Lance l : lances) {
			if (l.getUsuario().equals(usuario))
				total++;
		}
		return total;
	}

	
	/** 
	 * @return boolean
	 */
	private boolean estaSemLances() {
		return this.lances.isEmpty();
	}

	
	/** 
	 * @return Lance
	 */
	private Lance ultimoLanceDado() {
		return lances.get(lances.size() - 1);
	}

	
	/** 
	 * @return List<Lance>
	 */
	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	
	/** 
	 * @return boolean
	 */
	public boolean temLances() {
		return !this.lances.isEmpty();
	}

}
