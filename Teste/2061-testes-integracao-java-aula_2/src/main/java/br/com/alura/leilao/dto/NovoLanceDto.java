package br.com.alura.leilao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Usuario;

public class NovoLanceDto {

	@NotNull
	@DecimalMin(value = "0.1")
	private BigDecimal valor;

	private Long leilaoId;

	
	/** 
	 * @return BigDecimal
	 */
	public BigDecimal getValor() {
		return valor;
	}

	
	/** 
	 * @param valor
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	
	/** 
	 * @return Long
	 */
	public Long getLeilaoId() {
		return leilaoId;
	}

	
	/** 
	 * @param leilaoId
	 */
	public void setLeilaoId(Long leilaoId) {
		this.leilaoId = leilaoId;
	}

	
	/** 
	 * @param usuario
	 * @return Lance
	 */
	public Lance toLance(Usuario usuario) {
		Lance lance = new Lance(usuario, valor);
		lance.setData(LocalDate.now());
		return lance;
	}

}
