package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;

public class GeraPedidoHandler {

	private List<AcaoAposPedido> acoes;

	public GeraPedidoHandler(List<AcaoAposPedido> acoes) {
		this.acoes = acoes;
	}

	public void executar(GeraPedido geraPedido) {
		Orcamento orcamento = new Orcamento(geraPedido.getValorOrcamento(), geraPedido.getQuantidadeItens());
		Pedido pedido = new Pedido(geraPedido.getCliente(), LocalDateTime.now(), orcamento);
		acoes.forEach(a -> a.executar(pedido));
	}

}
