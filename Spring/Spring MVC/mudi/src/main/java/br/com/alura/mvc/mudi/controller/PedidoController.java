package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.Repository.PedidoRepository;
import br.com.alura.mvc.mudi.Repository.UserRepository;
import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisao) {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisao, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "pedido/formulario";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Pedido pedido = requisao.toPedido();
        pedido.setUser(userRepository.findByUsername(username));
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
